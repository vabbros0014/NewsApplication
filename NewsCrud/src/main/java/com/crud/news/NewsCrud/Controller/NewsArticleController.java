package com.crud.news.NewsCrud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.news.NewsCrud.Entity.NewsArticle;
import com.crud.news.NewsCrud.service.NewsCrudService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class NewsArticleController {
	
	@Autowired
	NewsCrudService newsCrudService;
	
	public NewsArticleController() {
		
	}
	
	@Autowired
	public NewsArticleController (NewsCrudService theNewsCrudService) {
		newsCrudService = theNewsCrudService;
	} 
	@GetMapping("/hello") 
	public void HelloWorld() {
		System.out.println("coming to Hello World");
	}
	
	
	@GetMapping("/bookmarks")
	public List<NewsArticle> findAllArticlesBookmarked() {
		System.out.println("coming to find All Resource");
		return	newsCrudService.findAllHeadlines();
	}
	
	@GetMapping("/bookmarks/user/{username}")
	public List<NewsArticle> findAllArticlesBookmarkedByUser(@PathVariable String username) {
		System.out.println("coming to find All Bookmark By Username");
		return	newsCrudService.findAllByUserName(username);
	}
	
	@PostMapping("/bookmarks/user/{userName}")
	public void addBookmark(@RequestBody NewsArticle article, @PathVariable String userName) throws Exception {
		System.out.println("coming to Add Bookmark");
		newsCrudService.addBookmarkToUser(article, userName);
		
	}
	
}
