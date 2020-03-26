package com.news.user.profile.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.news.user.profile.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	
	User findByUserId(Integer userId);
	User findByUsername(String username);
}
