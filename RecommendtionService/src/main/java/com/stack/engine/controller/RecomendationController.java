package com.stack.engine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stack.engine.model.NewsArticleDto;
import com.stack.engine.model.NewsArticleRto;
import com.stack.engine.service.RecommendationService;

@RestController
@RequestMapping("/engine")
@CrossOrigin("*")
public class RecomendationController {
	@Autowired
	RecommendationService recomService;
	
	@GetMapping("/fetchAll")
	public List<NewsArticleDto> fetchAllArticles() {
		return	recomService.findAllArticles();
		
	}

}
