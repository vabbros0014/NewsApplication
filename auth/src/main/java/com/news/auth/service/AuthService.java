package com.news.auth.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.news.auth.Model.AuthenticateRequest;
import com.news.auth.Model.User;
import com.news.auth.Util.AuthenticationExceptionHandler;


public interface AuthService {
	
	void registerUser(AuthenticateRequest authenticateRequest);
	
	UserDetails getUserByUserName(String username, String password) 
			throws AuthenticationExceptionHandler.UserNotFoundException,
			AuthenticationExceptionHandler.UserPasswordMisMatchException;
	
	Boolean validatePassword(CharSequence rawPassword, String storedPassword);

	void saveUser(User user);

}
