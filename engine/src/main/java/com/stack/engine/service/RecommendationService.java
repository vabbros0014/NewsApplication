package com.stack.engine.service;

import java.util.List;

import com.stack.engine.model.NewsArticleDto;


public interface RecommendationService {
	
	public List<NewsArticleDto> findAllArticles();

}
