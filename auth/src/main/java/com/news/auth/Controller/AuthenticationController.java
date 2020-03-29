package com.news.auth.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.news.auth.Model.AuthenticateRequest;
import com.news.auth.Model.AuthenticateResponse;
import com.news.auth.Model.User;
import com.news.auth.Util.JwtUtil;
import com.news.auth.dao.UserDao;
import com.news.auth.service.AuthService;

@RestController
@CrossOrigin("*")
public class AuthenticationController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	AuthService authService;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	UserDao userDao;

	
	/**
	 * @param request
	 * @return Register new user 
	 */
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ResponseEntity<User> registerNewUser(@RequestBody AuthenticateRequest request) {
		User user = new User(request.getUsername(), request.getPassword());
		authService.saveUser(user);
		return ResponseEntity.ok(user);
	}
	
	/**
	 * 
	 * @param authenticateRequest
	 * @return Auth token 
	 * @throws Exception
	 */
	@RequestMapping(value = "/authenticate", method=RequestMethod.POST)
	public ResponseEntity<AuthenticateResponse> createAuthentication(@RequestBody AuthenticateRequest authenticateRequest) 
			throws Exception{
		UserDetails userDetails = authService.getUserByUserName(authenticateRequest.getUsername(), authenticateRequest.getPassword());
		
				String jwt = jwtUtil.generateToken(userDetails);
				return ResponseEntity.ok(new AuthenticateResponse(jwt));
	}
	
	

}
