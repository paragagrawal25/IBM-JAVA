package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Account 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private int accID;

	@Column(name = "customer_id")
	private String customerID;
	
	@Column(name = "account_number",unique = true)
	private int accNumber;
	
	public Account() {
		
	}

	public Account(String customerID, int accNumber) 
	{
		super();
		this.customerID = customerID;
		this.accNumber = accNumber;
	}

	public int getAccID() {
		return accID;
	}

	public void setAccID(int accID) {
		this.accID = accID;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public int getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}
}
