package com.example.demo.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public interface EmployeeDAO extends CrudRepository<Employee, Integer>
{
	public Iterable<Employee> getEmployeeByDeptName(String deptName);
}
