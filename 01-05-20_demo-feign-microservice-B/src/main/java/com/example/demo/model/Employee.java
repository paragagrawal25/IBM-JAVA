package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String empID;
	private String empName;
	private String empEmail;
	private String deptName;
	
	public Employee(String empName, String empEmail, String deptName) {
		super();
		this.empName = empName;
		this.empEmail = empEmail;
		this.deptName = deptName;
	}
}
