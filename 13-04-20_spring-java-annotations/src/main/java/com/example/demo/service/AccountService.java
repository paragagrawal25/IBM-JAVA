package com.example.demo.service;

import java.util.List;

import com.example.demo.bean.Account;
import com.example.exceptions.AccNotFoundException;

public interface AccountService 
{
	public Account createAccount(Account account);
	public List<Account> getAllAccountDetails();
	public Account findByAccountNumber(String accountNumber);
	public int updateByAccountNumber(Account account) throws AccNotFoundException;
}
