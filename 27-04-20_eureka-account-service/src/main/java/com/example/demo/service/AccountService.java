package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Account;

public interface AccountService 
{
	public List<Account> getAllAccounts();
	
	public Account findAccountById(int accID);
}
