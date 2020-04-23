package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.*;

@Entity
@Table(name = "employee")
@ApiModel(description="All details about the Employee. ")
public class Employee 
{
	@ApiModelProperty(notes = "The database generated employee ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ApiModelProperty(notes = "The employee first name")
	@Column(name = "first_name")
	private String firstName;
	
	@ApiModelProperty(notes = "The employee last name")
	@Column(name = "last_name")
	private String lastName;
	
	@ApiModelProperty(notes = "The employee email id")
	@Column(name = "email")
	private String email;

	public int getId() {
		return id;
	}
	
	public Employee()
	{
		
	}
	
	public Employee(String firstName, String lastName, String email) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
}
