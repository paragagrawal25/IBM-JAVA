package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;

@RestController
@RequestMapping("/api")
public class AccountRestController 
{
	private AccountService accountService;

	@Autowired
	public AccountRestController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/accounts")
	public List<Account> getAllAccounts()
	{
		return accountService.getAllAccounts();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/accounts/{accID}")
	public Account getAccountById(@PathVariable int accID)
	{
		return accountService.findAccountById(accID);
	}
}
