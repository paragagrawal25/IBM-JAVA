package com.example.demo.fallback;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.demo.client.EmployeeClient;
import com.example.demo.model.Employee;

@Component
public class EmployeeFallback implements EmployeeClient{

	@Override
	public String callHi(String name) {
		// TODO Auto-generated method stub
		return "<p>service is currently not available come back later<p>";
	}

	@Override
	public ResponseEntity<Iterable<Employee>> getEmployeeByDeptName(String deptName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Employee> saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return null;
	}

}