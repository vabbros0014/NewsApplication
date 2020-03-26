package com.crud.news.NewsCrud.service;

import java.util.List;

import com.crud.news.NewsCrud.Entity.NewsArticle;

public interface NewsCrudService {

	
   public List<NewsArticle> findAllHeadlines();
	
   public List<NewsArticle> findAllByUserName(String userName);

   public void addBookmarkToUser(NewsArticle article, String userId) throws Exception;
   
   public void addToRecommendationEngine(NewsArticle article);
   
 //  public NewsUser addUser(NewsUser user) throws Exception;
	
}
