package com.news.user.profile.servcie;

import com.news.user.profile.exception.UserAlreadyExistException;
import com.news.user.profile.model.AuthResponse;
import com.news.user.profile.model.User;
import com.news.user.profile.model.UserPojo;

public interface UserService {

	
	public User addUser(User user) throws UserAlreadyExistException;

	public AuthResponse addUserToAuth(UserPojo pojo);
}
