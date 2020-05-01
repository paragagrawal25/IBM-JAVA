package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.fallback.EmployeeFallback;
import com.example.demo.model.Employee;

@FeignClient(value ="service-B", fallback = EmployeeFallback.class)
public interface EmployeeClient 
{
	@RequestMapping("/api/employees/hi")
	public String callHi(@RequestParam String name);
	
	@RequestMapping("/api/employees/{deptName}")
	public ResponseEntity<Iterable<Employee>> getEmployeeByDeptName(@PathVariable String deptName);
	
	@RequestMapping("/api/employees")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp);
}
