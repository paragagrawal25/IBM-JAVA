package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.client.EmployeeClient;
import com.example.demo.model.Employee;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api")
public class DepartmentController 
{
	private EmployeeClient employeeClient;
	
	@Autowired
	public DepartmentController(EmployeeClient employeeClient) {
	
		this.employeeClient = employeeClient;
	}

	@RequestMapping("/departments/hello")
	public ResponseEntity<String> sayHello(@RequestParam String name)
	{
		String result = employeeClient.callHi(name);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	@GetMapping("/departments/employees")
	public ResponseEntity<Iterable<Employee>> getEmployeeByDeptName(@RequestParam String deptName)
	{
		return  employeeClient.getEmployeeByDeptName(deptName);
	}
	
	@PostMapping("/departments/employees")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
	{
		return  employeeClient.saveEmployee(employee);
	}
}
