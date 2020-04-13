package com.example.demo.model;

public class Customer 
{
	private String customerID;
	private String customerName;
	private Address address;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(String customerName, Address address) {
		super();
		this.customerName = customerName;
		this.address = address;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	@Override
	public String toString() 
	{
		return "CUSTOMER DETAILS\nCustomerID = " + customerID + "\nCustomer Name = " + customerName + "\nAddress = " + address;
	}
}
