package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Account;
import com.example.demo.repo.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService
{
	private AccountRepository accRepo;
	
	@Autowired
	public AccountServiceImpl(AccountRepository accRepo) {
		super();
		this.accRepo = accRepo;
	}

	@Override
	public Account createAccount(Account account) 
	{
		return accRepo.createAccount(account);
	}

	@Override
	public List<Account> getAllAccountDetails() 
	{
		return accRepo.getAllAccountDetails();
	}

	@Override
	public Account findByAccountNumber(String accountNumber) 
	{
		return accRepo.findByAccountNumber(accountNumber);
	}

}
