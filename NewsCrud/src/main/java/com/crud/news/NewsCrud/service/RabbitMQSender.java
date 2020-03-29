package com.crud.news.NewsCrud.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.news.NewsCrud.Entity.NewsArticleRto;

@Service
public class RabbitMQSender {
	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void send(NewsArticleRto articlerto) {
		rabbitTemplate.convertAndSend("javainuse.exchange", "javainuse.routingkey", articlerto);

	}
}
