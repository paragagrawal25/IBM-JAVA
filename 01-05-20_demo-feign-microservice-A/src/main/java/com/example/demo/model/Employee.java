package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Employee 
{
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
