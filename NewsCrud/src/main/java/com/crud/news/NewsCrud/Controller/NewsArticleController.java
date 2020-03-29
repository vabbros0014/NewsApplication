package com.crud.news.NewsCrud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crud.news.NewsCrud.Entity.NewsArticle;
import com.crud.news.NewsCrud.service.NewsCrudService;

/**
 * @author user
 *
 */
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
	/**
	 * @return List of all News Article saved in DB
	 */
	@RequestMapping(value ="/bookmarks", method =RequestMethod.GET) 
	public ResponseEntity<List<NewsArticle>> fetchAllArticles() {
		List<NewsArticle> articleList= newsCrudService.findAllHeadlines();
		return new ResponseEntity<List<NewsArticle>>(articleList, HttpStatus.OK);
	}
	/**
	 * @param username
	 * @return bookmarked list of user
 	 */
	@RequestMapping(value ="/bookmarks/user/{username}", method =RequestMethod.GET) 
	public ResponseEntity<List<NewsArticle>> findAllArticlesBookmarkedByUser(@PathVariable String username) {
		System.out.println("coming to find All Bookmark By Username");
		List<NewsArticle> articleList =newsCrudService.findAllByUserName(username);
		return new ResponseEntity<List<NewsArticle>>(articleList, HttpStatus.OK);
	}
	
	/**
	 * Add bookmark to the user profile
	 * @param article
	 * @param userName
	 * @throws Exception
	 */
	@RequestMapping(value ="/bookmarks/user/{username}", method =RequestMethod.POST) 
	public ResponseEntity<?> addBookmark(@RequestBody NewsArticle article, @PathVariable String username) throws Exception {
		NewsArticle articleDto = newsCrudService.addBookmarkToUser(article, username);
		if(articleDto == null)
		return new ResponseEntity<String>("Article already present", HttpStatus.OK);
		else {
			return new ResponseEntity<NewsArticle>(articleDto, HttpStatus.CREATED);
		}
		
	}
	
}
