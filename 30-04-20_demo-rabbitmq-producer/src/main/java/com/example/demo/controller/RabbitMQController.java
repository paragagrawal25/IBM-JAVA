package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Account;
import com.example.demo.service.RabbitMQService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Account Management System", description = "Operations pertaining to add account info in Account Management System")
public class RabbitMQController 
{
	@Autowired
	private RabbitMQService rabbitMqService;
	
	@PostMapping("/accounts")
	@ApiOperation(value = "Add an account")
	public ResponseEntity<String> postMessage(@RequestBody Account accInfo)
	{
		rabbitMqService.sendMessage(accInfo);
		return new ResponseEntity<String>("ITEM PUSHED TO RABBITMQ",HttpStatus.ACCEPTED);
	}
}
