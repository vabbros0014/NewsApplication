package com.news.user.profile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.news.user.profile.exception.UserAlreadyExistException;
import com.news.user.profile.model.User;
import com.news.user.profile.model.UserPojo;
import com.news.user.profile.model.UserRto;
import com.news.user.profile.servcie.AuthServiceProxy;
import com.news.user.profile.servcie.Mapper;
import com.news.user.profile.servcie.UserService;

@RestController
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	UserService userService;
	@Autowired
	private AuthServiceProxy proxy;
	
	@Autowired
	RestTemplate restTemplate;

	
	/**
	 * @param userRto
	 * @return Add user to profile DB 
	 * @throws UserAlreadyExistException
	 */
	@RequestMapping(value ="/signup", method =RequestMethod.POST) 
	public ResponseEntity<?> addUser(@RequestBody UserRto userRto) throws UserAlreadyExistException {
		ResponseEntity responseEntity = null;
		try {
		User user = Mapper.mapUser(userRto);
		userService.addUser(user);
		
		responseEntity =new ResponseEntity<String>("Successfully Created", HttpStatus.CREATED);
		} catch(UserAlreadyExistException e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
            e.printStackTrace();
		}
		
		UserPojo pojo = new UserPojo(userRto.getUsername(),userRto.getPassword());
		
		userService.addUserToAuth(pojo);
		
		return responseEntity ;
	}
	
	/**
	 * @param userRto
	 * @return Add user to profile DB
	 * @throws UserAlreadyExistException
	 */
	@RequestMapping(value ="/feign-signup", method =RequestMethod.POST) 
	public ResponseEntity<?> addUserFeign(@RequestBody UserRto userRto) throws UserAlreadyExistException {
		
		ResponseEntity responseEntity = null;
		try {
		User user = Mapper.mapUser(userRto);
		userService.addUser(user);
		} catch(UserAlreadyExistException e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
            e.printStackTrace();
		}
		UserPojo pojo = new UserPojo(userRto.getUsername(),userRto.getPassword());
		ResponseEntity<?> entity =	proxy.registerNewUser(pojo);
		return responseEntity;
		
		
	}
		


}
