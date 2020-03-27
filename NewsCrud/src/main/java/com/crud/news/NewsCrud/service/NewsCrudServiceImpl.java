package com.crud.news.NewsCrud.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import com.crud.news.NewsCrud.Dao.NewsArticleDao;
import com.crud.news.NewsCrud.Entity.NewsArticle;
import com.crud.news.NewsCrud.Entity.NewsArticleRto;

@Service
public class NewsCrudServiceImpl implements NewsCrudService {

	private static Logger logger = LoggerFactory.getLogger(NewsCrudServiceImpl.class);
	
	private NewsArticleDao articleDao;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired 
	RabbitMQSender rabbitMQSsender;
	@Autowired
	 public NewsCrudServiceImpl(NewsArticleDao theArticleDao) {
		this.articleDao = theArticleDao;
	}
	
	public NewsCrudServiceImpl() {}
	
	
	/**
	 *@return all articles save in db
	 */
	@Override
	public List<NewsArticle> findAllHeadlines() {
		return articleDao.findAll();
	}
	
	/**
	 *@return all articles bookmarked by user
	 */
	@Override
	public List<NewsArticle> findAllByUserName(String username) {
		return articleDao.findAllByUsername(username);
	}

	
	/**
	 *Add bookamark to user profile
	 */
	@Override
	public void addBookmarkToUser(NewsArticle article, String userName) throws Exception {
		Boolean articleExists = false;
		List<NewsArticle> articleList = articleDao.findAllByUsername(userName);
		
		if (!CollectionUtils.isEmpty(articleList)) {
			for (NewsArticle newsArticle : articleList) {
				if (newsArticle.getTitle().equalsIgnoreCase(article.getTitle())) {
					articleExists = true;
				}
			}
		}
		if (!articleExists) {
			logger.info("article not exist and going to add in engine");
			article.setUsername(userName);
			addToRecommendationEngine(article);
			try {
				articleDao.save(article);
			} catch (Exception e) {
				logger.debug(e.getMessage());
			}
		}
	}

	/**
	 * Add news Article to Recommendation Engine
	 */
	@Override
	public void addToRecommendationEngine(NewsArticle article) {
		NewsArticleRto rto =convertToRto(article);
		rabbitMQSsender.send(rto);
		logger.info("Message send to Rabbit Mq successfully");
			
	}

	/**
	 * Mapper to convert to Rto
	 * @param article
	 * @return
	 */
	private NewsArticleRto convertToRto(NewsArticle article) {
		NewsArticleRto rto = new NewsArticleRto();
		rto.setAuthor(article.getAuthor());
		rto.setDescription(article.getDescription());
		rto.setPublishedAt(article.getPublishedAt());
		rto.setTitle(article.getTitle());
		rto.setUrl(article.getUrl());
		rto.setUrlToImage(article.getUrlToImage());
		return rto;
	}

	
}