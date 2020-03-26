package com.crud.news.NewsCrud.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.crud.news.NewsCrud.Entity.NewsArticleRto;

@Service
public class RabbitMQSender {
@Autowired
private RabbitTemplate rabbitTemplate;

@Value("${javainuse.rabbitmq.exchange}")
private String exchange;

@Value("${javainuse.rabbitmq.routingkey}")
private String routingkey;	

public void send(NewsArticleRto articlerto) {
	rabbitTemplate.convertAndSend(exchange, routingkey, articlerto);
	System.out.println("Send msg = " + articlerto);
    
}
}