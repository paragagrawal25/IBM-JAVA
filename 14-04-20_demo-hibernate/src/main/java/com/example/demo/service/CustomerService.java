package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Customer;

public interface CustomerService 
{
	public Customer createCustomer(Customer customer);
	public List<Customer> getAllCustomers();
	public Customer getCustomerByID(int customerID);
}
