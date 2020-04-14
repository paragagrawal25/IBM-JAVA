package com.example.demo.DAO;

import java.util.List;

import com.example.demo.entity.Customer;

public interface CustomerDAO 
{
	public Customer createCustomer(Customer customer);
	public List<Customer> getAllCustomers();
	public Customer getCustomerByID(String customerID);
}
