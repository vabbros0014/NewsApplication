package com.crud.news.NewsCrud.Dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.crud.news.NewsCrud.Entity.NewsArticle;


@Repository
public interface NewsArticleDao extends MongoRepository<NewsArticle, String>{
	
	List<NewsArticle> findAll();
	List<NewsArticle> findAllByUsername(String username);
	NewsArticle findOneById(String id);
	NewsArticle findOneByAuthor(String author);
		
}
