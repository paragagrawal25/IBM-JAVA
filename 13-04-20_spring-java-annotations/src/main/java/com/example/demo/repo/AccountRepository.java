package com.example.demo.repo;

import java.util.List;

import com.example.demo.bean.Account;
import com.example.exceptions.AccNotFoundException;

public interface AccountRepository 
{
	public Account createAccount(Account account);
	public List<Account> getAllAccountDetails();
	public Account findByAccountNumber(String accountNumber);
	public int updateByAccountNumber(Account account) throws AccNotFoundException;
}
