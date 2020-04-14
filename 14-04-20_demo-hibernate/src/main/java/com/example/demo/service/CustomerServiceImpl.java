package com.example.demo.service;

import java.util.List;

import com.example.demo.DAO.CustomerDAO;
import com.example.demo.DAO.CustomerDAOImpl;
import com.example.demo.entity.Customer;

public class CustomerServiceImpl implements CustomerService 
{
	private CustomerDAO customerDAO;
	
	{
		customerDAO = new CustomerDAOImpl();
	}
	
	@Override
	public Customer createCustomer(Customer customer) 
	{
		return customerDAO.createCustomer(customer);
	}

	@Override
	public List<Customer> getAllCustomers() 
	{
		return customerDAO.getAllCustomers();
	}

	@Override
	public Customer getCustomerByID(String customerID) 
	{
		return customerDAO.getCustomerByID(customerID);
	}

}
