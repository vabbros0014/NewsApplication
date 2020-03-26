package com.stack.engine.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stack.engine.model.NewsArticleDto;


@Repository
public interface EngineDao extends MongoRepository<NewsArticleDto, String>{
	
	NewsArticleDto findOneByTitle(String title);

}
