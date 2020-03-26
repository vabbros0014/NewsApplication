package com.stack.engine.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stack.engine.dao.EngineDao;
import com.stack.engine.model.NewsArticleDto;
import com.stack.engine.model.NewsArticleRto;

@Component
public class RabbitMQConsumer {
	@Autowired
	EngineDao dao;

	@RabbitListener(queues = "${javainuse.rabbitmq.queue}")
	public void recievedMessage(NewsArticleRto rto) {
		System.out.println("Recieved Message From RabbitMQ: " + rto);
		NewsArticleDto newsArticleDto = dao.findOneByTitle(rto.getTitle());
		if(newsArticleDto == null) {
			newsArticleDto = convertToDto(rto);
			newsArticleDto.setRecommendations(1);
		} else {
			newsArticleDto.setRecommendations(newsArticleDto.getRecommendations() +1);
		}
		dao.save(newsArticleDto);
	}



	private NewsArticleDto convertToDto(NewsArticleRto rto) {
		NewsArticleDto dto = new NewsArticleDto();
		dto.setAuthor(rto.getAuthor());
		dto.setDescription(rto.getDescription());
		dto.setPublishedAt(rto.getPublishedAt());
		dto.setTitle(rto.getTitle());
		dto.setUrl(rto.getUrl());
		dto.setUrlToImage(rto.getUrlToImage());
		
		return dto;
	}
}