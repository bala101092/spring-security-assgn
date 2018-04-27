package com.moviebuff.mongodb.application.service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * @author Balamurugan M
 *
 */
@Service
public class LoginAttemptService {
 
    private final int MAX_ATTEMPT = 10;
    private LoadingCache<String, Integer> attemptsCache;
 
    /**
     * Default Constructor
     */
    public LoginAttemptService() {
        super();
        attemptsCache = CacheBuilder.newBuilder().
          expireAfterWrite(1, TimeUnit.DAYS).build(new CacheLoader<String, Integer>() {
            public Integer load(String key) {
                return 0;
            }
        });
    }
 
    /**
     * @param key
     */
    public void loginSucceeded(String key) {
        attemptsCache.invalidate(key);
    }
 
    /**
     * @param key
     */
    public void loginFailed(String key) {
    	System.out.println("Login Failed");
        int attempts = 0;
        try {
            attempts = attemptsCache.get(key);
        } catch (ExecutionException e) {
            attempts = 0;
        }
        attempts++;
        attemptsCache.put(key, attempts);
    }
 
    /**
     * @param key
     * @return
     */
    public boolean isBlocked(String key) {
        try {
            return attemptsCache.get(key) >= MAX_ATTEMPT;
        } catch (ExecutionException e) {
            return false;
        }
    }
}