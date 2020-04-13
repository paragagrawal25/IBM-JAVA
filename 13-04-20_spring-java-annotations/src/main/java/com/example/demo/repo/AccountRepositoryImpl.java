package com.example.demo.repo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.Account;
import com.example.demo.bean.AccountRowMapper;
import com.example.exceptions.AccNotFoundException;

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

	@Override
	public int updateByAccountNumber(Account account) throws AccNotFoundException
	{
		String UPDATE_QUERY = "UPDATE ACCOUNT SET accountType=?, initialBalance=? where accountNumber=?";
		/*Account account1 = jdbcTemplate.queryForObject(UPDATE_QUERY, new Object[] {account.getAccountType(), account.getInitialBalance(),
							account.getAccountNumber()}, new AccountRowMapper());*/
		
		int updateRowCount = jdbcTemplate.update(UPDATE_QUERY, account.getAccountType(), account.getInitialBalance(), account.getAccountNumber());
		
		if(updateRowCount <= 0)
			throw new AccNotFoundException("NO RECORD IS FOUND BY THIS ACCOUNT NUMBER "+account.getAccountNumber());

		return updateRowCount;
	}

}
