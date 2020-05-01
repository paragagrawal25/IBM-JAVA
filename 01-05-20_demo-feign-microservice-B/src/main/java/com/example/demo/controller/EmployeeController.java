package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DAO.EmployeeDAO;
import com.example.demo.model.Employee;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api")
public class EmployeeController 
{
	@Autowired
	private EmployeeDAO empDAO;
	
	@RequestMapping("/employees/hi")
	public String hi(@RequestParam String name)
	{
		return "hi"+name;
	}
	
	@GetMapping("/employees/{deptName}")
	public ResponseEntity<Iterable<Employee>> getEmployeeByDeptName(@PathVariable String deptName)
	{
		return ResponseEntity.ok().body(empDAO.getEmployeeByDeptName(deptName));
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp)
	{
		return ResponseEntity.ok().body(empDAO.save(emp));
	}
}
