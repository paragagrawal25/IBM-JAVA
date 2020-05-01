package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Account;
import com.example.demo.service.RabbitMQConsumerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Account Management System", description = "Operations pertaining to add account info in Account Management System")
public class RabbitMQConsumerController 
{
	private RabbitMQConsumerService rabbitMqService;

	@Autowired
	public RabbitMQConsumerController(RabbitMQConsumerService rabbitMqService) {
		super();
		this.rabbitMqService = rabbitMqService;
	}
	
	@GetMapping("/accounts")
	@ApiOperation(value = "Display All Accounts")
	public List<Account> getAllAccounts()
	{
		return rabbitMqService.getAllAccounts();
	}
	
	@GetMapping("/accounts/{accID}")
	@ApiOperation(value = "Display An Account By Account ID")
	public Account getAccountByID(@PathVariable int accID)
	{
		return rabbitMqService.getAccountByAccountID(accID);
	}
	
	@DeleteMapping("/accounts/{accID}")
	@ApiOperation(value = "Delete An Account By Account ID")
	public void deleteAccountByID(@PathVariable int accID)
	{
		rabbitMqService.deleteAccountByAccountID(accID);
	}
}
