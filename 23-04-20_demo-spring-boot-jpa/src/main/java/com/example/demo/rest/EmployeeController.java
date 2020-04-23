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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Employee Management System", description = "Operations pertaining to employee in Employee Management System")
public class EmployeeController 
{
	private EmployeeDAO refEmployeeDAO;
	
	@Autowired
	public EmployeeController(EmployeeDAO refEmployeeDAO) {
		super();
		this.refEmployeeDAO = refEmployeeDAO;
	}
	
	@ApiOperation(value = "Add an employee")
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee)
	{
		return refEmployeeDAO.createEmployee(employee);
	}
	
	@ApiOperation(value = "View a list of available employees", response = List.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") 
			})
	
	@GetMapping("/employees")
	public List<Employee> getEmployeesList()
	{
		return refEmployeeDAO.getEmployees();
	}
	
	@ApiOperation(value = "Get an employee by Id")
	@GetMapping("/employees/{empID}")
	public Employee getEmployeeByID(@PathVariable int empID)
	{
		return refEmployeeDAO.getEmployee(empID);
	}
	
	@ApiOperation(value = "Delete an employee")
	@DeleteMapping("/employees/{empID}")
	public void deleteEmployee(@PathVariable int empID)
	{
		refEmployeeDAO.deleteEmployee(empID);
	}
}
