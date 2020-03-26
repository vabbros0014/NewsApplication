package com.stack.engine.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stack.engine.dao.EngineDao;
import com.stack.engine.model.NewsArticleDto;
import com.stack.engine.model.NewsArticleRto;

@Service
public class RecommendationServiceImpl implements RecommendationService{

	@Autowired
	EngineDao dao;

	@Override
	public List<NewsArticleDto> findAllArticles() {
		List<NewsArticleDto> list = dao.findAll();
		Collections.sort(list);
		return list;
	}

}
