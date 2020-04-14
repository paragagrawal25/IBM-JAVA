package com.example.demo.entity;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name="customer")
public class Customer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")
	private int customerID;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="customer_email")
	private String customerEmail;
	
	@Column(name="is_active")
	private boolean isActive;

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", isActive=" + isActive + "]";
	}
}
