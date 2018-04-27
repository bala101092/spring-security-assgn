/*package com.moviebuff.mongodb.application.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import com.moviebuff.mongodb.application.service.LoginAttemptService;

@Component
public class AuthenticationFailureListener 
  implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {
 
	@Autowired
    private HttpServletRequest request;
	
    @Autowired
    private LoginAttemptService loginAttemptService;
 
    public void onApplicationEvent(final AuthenticationFailureBadCredentialsEvent e) {
    	
        WebAuthenticationDetails auth = (WebAuthenticationDetails) 
          e.getAuthentication().getDetails();
         
        loginAttemptService.loginFailed(auth.getRemoteAddress());
    	
    	final String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null) {
            loginAttemptService.loginFailed(request.getRemoteAddr());
        } else {
            loginAttemptService.loginFailed(xfHeader.split(",")[0]);
        }
    }
}*/