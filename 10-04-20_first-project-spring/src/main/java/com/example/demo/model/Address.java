package com.example.demo.model;

import lombok.*;

@Setter
public class Address 
{
	private String addressLine1;
	private String addressLine2;
	
	@Override
	public String toString() 
	{
		return addressLine1 + ", " + addressLine2;
	}
}
