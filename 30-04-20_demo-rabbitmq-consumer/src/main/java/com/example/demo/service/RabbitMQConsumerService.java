package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Account;

public interface RabbitMQConsumerService 
{
	public List<Account> getAllAccounts();
	
	public Account getAccountByAccountID(int accID);
	
	public void deleteAccountByAccountID(int accID);
}
