package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AccountDAO;
import com.example.demo.entity.Account;

@Service
public class AccountServiceImpl implements AccountService
{
	private AccountDAO accountDAO;
	
	@Autowired
	public AccountServiceImpl(AccountDAO accountDAO) {
		super();
		this.accountDAO = accountDAO;
	}

	@Override
	public List<Account> getAllAccounts() 
	{
		return (List<Account>) accountDAO.findAll();
	}

	@Override
	public Account findAccountById(int accID) 
	{
		return accountDAO.findById(accID).get();
	}

}
