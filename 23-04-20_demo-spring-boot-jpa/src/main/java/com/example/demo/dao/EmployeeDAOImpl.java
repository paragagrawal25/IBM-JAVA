package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Employee;

@Repository("employeeDAO")
@EnableTransactionManagement
public class EmployeeDAOImpl implements EmployeeDAO
{
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOImpl(EntityManager entityManager) 
	{
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public Employee createEmployee(Employee employee) 
	{
		entityManager.persist(employee);
		return employee;
	}

	@Override
	public List<Employee> getEmployees() 
	{
		TypedQuery<Employee> query = entityManager.createQuery("from Employee",Employee.class);
		return query.getResultList();
	}

	@Override
	public Employee getEmployee(int empID) 
	{
		return entityManager.find(Employee.class, empID);
	}

	@Override
	public void deleteEmployee(int empID) 
	{
		Employee employee = getEmployee(empID);
		if(employee != null)
		{
			entityManager.remove(employee);
		}
	}

	@Override
	public void updateEmployee(int empID) 
	{
		
	}

}
