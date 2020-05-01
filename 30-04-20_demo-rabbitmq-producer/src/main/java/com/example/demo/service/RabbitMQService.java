package com.example.demo.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Account;

@Service
public class RabbitMQService 
{
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	private String EXCHANGE = "otp-exchange";
	
	private String ROUTING_KEY = "accounts";
	
	public void sendMessage(Account accInfo)
	{
		amqpTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, accInfo);
	}
}
