package com.news.user.profile.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.news.user.profile.exception.UserAlreadyExistException;
import com.news.user.profile.model.User;
import com.news.user.profile.servcie.UserService;

//@RunWith(SpringRunner.class)
//@WebMvcTest
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private User user;
    @MockBean
    private UserService userService;
    @InjectMocks
    private UserController userController;

    private List<User> list =null;

    @Before
    public void setUp(){

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        user = new User();
        user.setCity("Jaipur");
        user.setCountry("India");
        user.setEmailId("stack@test.com");
        user.setFirstName("stack");
        user.setLastName("user");
        user.setUsername("stackuser1");
        list = new ArrayList();
        list.add(user);
    }


	/*
	 * @Test public void saveUser() throws Exception {
	 * when(userService.addUser(user)).thenReturn(user);
	 * mockMvc.perform(MockMvcRequestBuilders.post("/signup").contentType(MediaType.
	 * APPLICATION_JSON)
	 * .content(asJsonString(user))).andExpect(MockMvcResultMatchers.status().
	 * isConflict()) .andDo(MockMvcResultHandlers.print()); Assert.assertEquals(1,
	 * list.size());
	 * 
	 * }
	 * 
	 * @Test public void saveUserFailure() throws Exception {
	 * when(userService.addUser(any())).thenThrow(UserAlreadyExistException.class);
	 * mockMvc.perform(MockMvcRequestBuilders.post("/signup").contentType(MediaType.
	 * APPLICATION_JSON)
	 * .content(asJsonString(user))).andExpect(MockMvcResultMatchers.status().
	 * isConflict()) .andDo(MockMvcResultHandlers.print()); }
	 */

	/*
	 * private static String asJsonString(final Object obj) { try{ return new
	 * ObjectMapper().writeValueAsString(obj);
	 * 
	 * }catch(Exception e){ throw new RuntimeException(e); } }
	 * 
	 * 
	 */







}