package com.news.auth.service;

import java.util.ArrayDeque;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.news.auth.Model.AuthenticateRequest;
import com.news.auth.Model.User;
import com.news.auth.Util.AuthenticationExceptionHandler;
import com.news.auth.dao.UserDao;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserDao userDao;

	 private static Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);
	   
	@Override
	public void registerUser(AuthenticateRequest authenticateRequest) {

		
	}
	
	/**
	 * Get user by username
	 */
	@Override
	public UserDetails getUserByUserName(String username, String password) throws AuthenticationExceptionHandler.UserNotFoundException,
	AuthenticationExceptionHandler.UserPasswordMisMatchException{
		UserDetails userDetails = null;
		User user = userDao.findOneByUsername(username);
		if(!validatePassword(password,user.getPassword())) {
	        throw new AuthenticationExceptionHandler.UserPasswordMisMatchException("Given password does not match");
	        
		}
		if (user != null) {
			logger.info("user data", user);
			userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					new ArrayDeque<>());
		} else {
			throw new AuthenticationExceptionHandler.UserPasswordMisMatchException("User not found");
		}
		return userDetails;
	}

	/**
	 * Validate user 
	 */
	@Override
	public Boolean validatePassword(CharSequence rawPassword, String storedPassword) {
		 return (passwordEncoder.matches(rawPassword, storedPassword));
	}

	/**
	 *save user to userdb
	 */
	@Override
	public void saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userDao.save(user);
		
	}

}
