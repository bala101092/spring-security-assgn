package com.moviebuff.mongodb.application.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebuff.mongodb.application.entity.User;
import com.moviebuff.mongodb.application.repository.UserRepository;

/**
 * @author Balamurugan M
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private LoginAttemptService loginAttemptService;
  
    @Autowired
    private HttpServletRequest request;

	/* (non-Javadoc)
	 * @see com.moviebuff.mongodb.application.service.UserService#save(com.moviebuff.mongodb.application.entity.User)
	 */
	public User save(User user) {
		return userRepository.save(user);
	}

	/*public User findByEmail(String email) {
		
		System.out.println("Inside findByEmail method");
		
		String ip = getClientIP();
        if (loginAttemptService.isBlocked(ip)) {
            throw new RuntimeException("blocked");
        }
  
        try {
            User user = userRepository.findByEmail(email);
            if (user == null) {
            	System.out.println("Login Failed. No User Found");
                return new org.springframework.security.core.userdetails.User(
                  " ", " ", true, true, true, true, 
                  getAuthorities(Arrays.asList(roleRepository.findByName("ROLE_USER"))));
            	
            	loginAttemptService.loginFailed(ip);
            	
            }else{
            	System.out.println("Login Successfull");
            	return new org.springframework.security.core.userdetails.User(
              user.getEmail(), user.getPassword(), user.isEnabled(), true, true, true, 
              getAuthorities(user.getRoles()));

            	loginAttemptService.loginSucceeded(ip);
            	return user;
            }
  
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
		
		
		return userRepository.findByEmail(email);
	}*/
	
	/* (non-Javadoc)
	 * @see com.moviebuff.mongodb.application.service.UserService#findByEmail(java.lang.String)
	 */
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	private String getClientIP() {
	    String xfHeader = request.getHeader("X-Forwarded-For");
	    if (xfHeader == null){
	        return request.getRemoteAddr();
	    }
	    return xfHeader.split(",")[0];
	}
}
