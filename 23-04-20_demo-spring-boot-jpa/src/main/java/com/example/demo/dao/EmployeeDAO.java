package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeDAO 
{
	public Employee createEmployee(Employee employee);
	
	public List<Employee> getEmployees();
	
	public Employee getEmployee(int empID);
	
	public void deleteEmployee(int empID);
	
	public void updateEmployee(int empID);
}
