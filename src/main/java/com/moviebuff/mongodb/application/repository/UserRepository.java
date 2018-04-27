package com.moviebuff.mongodb.application.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.moviebuff.mongodb.application.entity.User;

public interface UserRepository extends Repository<User, String> {
	
	User delete(User deleted);
	 
    List<User> findAll();
 
    Optional<User> findOne(String id);
 
    User save(User saved);
    
    User findByEmail(String email);

}
