package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeController 
{
	private EmployeeDAO refEmployeeDAO;

	@Autowired
	public EmployeeController(EmployeeDAO refEmployeeDAO) {
		super();
		this.refEmployeeDAO = refEmployeeDAO;
	}
	
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee)
	{
		return refEmployeeDAO.createEmployee(employee);
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployeesList()
	{
		return refEmployeeDAO.getEmployees();
	}
	
	@GetMapping("/employees/{empID}")
	public Employee getEmployeeByID(@PathVariable int empID)
	{
		return refEmployeeDAO.getEmployee(empID);
	}
	
	@DeleteMapping("/employees/{empID}")
	public void getEmployeesList(@PathVariable int empID)
	{
		refEmployeeDAO.deleteEmployee(empID);
	}
}
