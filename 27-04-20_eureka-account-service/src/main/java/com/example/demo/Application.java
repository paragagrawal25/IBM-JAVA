package com.example.demo;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.dao.AccountDAO;
import com.example.demo.entity.Account;

@SpringBootApplication
@EnableDiscoveryClient
public class Application implements CommandLineRunner
{
	private AccountDAO accountDAO;
	
	@Autowired
	public Application(AccountDAO accountDAO) {
		super();
		this.accountDAO = accountDAO;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		accountDAO.save(new Account(UUID.randomUUID().toString(),32156));
		accountDAO.save(new Account(UUID.randomUUID().toString(),32856));
		accountDAO.save(new Account(UUID.randomUUID().toString(),36871));
		accountDAO.save(new Account(UUID.randomUUID().toString(),39812));
	}
}
