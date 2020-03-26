package com.news.user.profile.service;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.news.user.profile.dao.UserDao;
import com.news.user.profile.exception.UserAlreadyExistException;
import com.news.user.profile.model.User;
import com.news.user.profile.servcie.UserServiceImpl;

public class UserServiceTest {

    User user;

    //Create a mock for UserRepository
    @Mock
    UserDao userRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    UserServiceImpl userService;
    List<User> list= null;


    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        user = new User();
        user.setCity("Jaipur");
        user.setCountry("India");
        user.setEmailId("stack@test.com");
        user.setFirstName("stack");
        user.setLastName("user");
        user.setUsername("stackuser1");
        list = new ArrayList<>();
        list.add(user);


    }

	/*
	 * @Test public void saveUserTestSuccess() throws UserAlreadyExistException {
	 * when(userRepository.save((User)any())).thenReturn(user); User savedUser =
	 * userService.addUser(user); Assert.assertEquals(user,savedUser);
	 * verify(userRepository,times(1)).save(user);
	 * 
	 * 
	 * }
	 */

	/*
	 * @Test(expected = UserAlreadyExistException.class) public void
	 * saveUserTestFailure() throws UserAlreadyExistException {
	 * when(userRepository.save(user)any())).thenReturn(user);
	 * userService.addUser(user);
	 * 
	 * }
	 */

    }