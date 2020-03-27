package com.news.user.profile.servcie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.news.user.profile.dao.UserDao;
import com.news.user.profile.exception.UserAlreadyExistException;
import com.news.user.profile.model.AuthResponse;
import com.news.user.profile.model.User;
import com.news.user.profile.model.UserPojo;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired 
	UserDao userDao;
	
	@Autowired
	RestTemplate restTemplate;

	/**
	 * Add user to DB
	 */
	@Override
	public User addUser(User user) throws UserAlreadyExistException{
	
		System.out.println("Coming to add User");
		if(userDao.findByUsername(user.getUsername()) != null) {
			throw new UserAlreadyExistException("User Already Exists");
		} else {
			userDao.save(user);
		}
		return user;
	}

	/**
	 * Add user to auth service
	 */
	@Override
	public AuthResponse addUserToAuth(UserPojo pojo) {
		// TODO Auto-generated method stub

		HttpEntity<UserPojo> request = new HttpEntity(pojo);

		ResponseEntity<AuthResponse> authresponse = restTemplate.postForEntity("http://localhost:8000/register",
				request, AuthResponse.class);
		
		System.out.println("Output from Server .... \n");
		int output = authresponse.getStatusCodeValue();
		System.out.println(output);
		
		return authresponse.getBody();
		
	}

}
