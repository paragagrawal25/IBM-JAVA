package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.RabbitMQConsumerDAO;
import com.example.demo.model.Account;

@Service
public class RabbitMQConsumerServiceImpl implements RabbitMQConsumerService
{
	@Autowired
	private RabbitMQConsumerDAO rabbitmqDAO;
	
	private static final String QUEUE = "accounts-queue";
	
	/*@RabbitListener(queues = QUEUE)
	public void receiveMessage(Item item)
	{
		System.out.println("Received Message from Items Queue >>" + item);
		rabbitmqDAO.save(item);
	}*/
	
	List<Account> accountsList = new ArrayList<>();
	@RabbitListener(queues = QUEUE)
	@Transactional
	public void receiveMessage(Account account)
	{
		accountsList.add(account);
		System.out.println("Received Message from Items Queue >>" + account);
		if(!(accountsList.isEmpty()))
		{
			for(Account acc : accountsList)
			{
				rabbitmqDAO.save(acc);
			}
		}
	}
	
	@Override
	public List<Account> getAllAccounts() 
	{
		return (List<Account>) rabbitmqDAO.findAll();
	}
	
	@Override
	public Account getAccountByAccountID(int accID) 
	{
		return rabbitmqDAO.findById(accID).get();
	}
	
	@Override
	public void deleteAccountByAccountID(int accID) 
	{
		rabbitmqDAO.deleteById(accID);
	}
}
