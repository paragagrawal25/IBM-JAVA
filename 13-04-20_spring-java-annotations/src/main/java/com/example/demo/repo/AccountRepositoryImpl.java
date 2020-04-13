package com.example.demo.repo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.Account;
import com.example.demo.bean.AccountRowMapper;

@Repository
public class AccountRepositoryImpl implements AccountRepository
{
	private JdbcTemplate jdbcTemplate;
	private Logger logger = Logger.getLogger("AccountRepositoryImpl");
	
	@Autowired
	public AccountRepositoryImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Account createAccount(Account account) 
	{
		String query = "insert into account(accountNumber,accountType,initialBalance) values('" 
						+account.getAccountNumber()+"','" 
						+account.getAccountType()+"',"+account.getInitialBalance()+")";
		jdbcTemplate.update(query);
		return account;
	}

	@Override
	public List<Account> getAllAccountDetails() 
	{
		//List<Account> accountsList = jdbcTemplate.query("select * from account",new AccountRowMapper());
		List<Account> accountsList = jdbcTemplate.query("select * from account",new BeanPropertyRowMapper(Account.class));
		return accountsList;
	}

	@Override
	public Account findByAccountNumber(String accountNumber) 
	{
		Account account = jdbcTemplate.queryForObject("select * from account where accountNumber=?", 
							new Object[] {accountNumber},new AccountRowMapper());
		return account;
	}

}
