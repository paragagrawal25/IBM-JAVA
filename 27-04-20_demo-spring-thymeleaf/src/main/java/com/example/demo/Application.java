package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.DAO.ProductDAO;
import com.example.demo.entity.Product;

@SpringBootApplication
public class Application implements CommandLineRunner
{
	ProductDAO refProductDAO;
	
	@Autowired
	public Application(ProductDAO refProductDAO) {
		super();
		this.refProductDAO = refProductDAO;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		refProductDAO.save(new Product("Samsung Mobile",new BigDecimal(12.5),"mobile.jpg"));
		refProductDAO.save(new Product("Oneplus 8 Pro",new BigDecimal(52.5),"oneplus.jpg"));
		refProductDAO.save(new Product("Huawei",new BigDecimal(22.5),"huawei.jpg"));
		refProductDAO.save(new Product("Mi TV",new BigDecimal(28.0),"mitv.jpg"));
	}
}
