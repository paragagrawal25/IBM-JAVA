package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Account.class)
@Data
@NoArgsConstructor
public class Account 
{	
	private int accountNumber;
	
	private String customerName;
	
	private String customerEmail;
}
