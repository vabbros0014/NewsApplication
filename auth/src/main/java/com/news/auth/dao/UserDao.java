package com.news.auth.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.news.auth.Model.User;

public interface UserDao extends MongoRepository<User, String> {

	User findOneByUsername(String username);
}
