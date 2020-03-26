package com.news.user.profile.repository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.news.user.profile.dao.UserDao;
import com.news.user.profile.model.User;

public class UserRepositoryTest {

    @Autowired
    UserDao userRepository;
    User user;

    @Before
    public void setUp()
    {
        user = new User();
        user.setFirstName("Test");
        user.setLastName("USer");
        user.setUsername("stackUser");
        user.setEmailId("Jenny@gmail.com");

    }

    @After
    public void tearDown(){

        userRepository.deleteAll();
    }


	/*
	 * @Test public void testSaveUser(){ userRepository.save(user); User fetchUser =
	 * userRepository.findByUsername("Jenny@gmail.com");
	 * Assert.assertEquals("Test",fetchUser.getFirstName());
	 * Assert.assertEquals("stackuser",fetchUser.getUsername()); }
	 */

	/*
	 * @Test public void testSaveUserFailure(){ User testUser = new
	 * User("Harry","john",34,"Harry123",201); userRepository.save(user); User
	 * fetchUser = userRepository.findById(user.getId()).get();
	 * Assert.assertNotSame(testUser,user); }
	 */

  


    }
