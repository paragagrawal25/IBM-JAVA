package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.CustomerDAO;
import com.example.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	private CustomerDAO refCustomerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() 
	{
		return refCustomerDAO.getCustomers();
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) 
	{
		return refCustomerDAO.getCustomer(theId);
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) 
	{
		refCustomerDAO.saveCustomer(theCustomer);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) 
	{
		refCustomerDAO.deleteCustomer(theId);
	}

}
