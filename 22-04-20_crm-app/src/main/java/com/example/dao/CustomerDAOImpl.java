package com.example.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO
{
	@Autowired
	private SessionFactory sessionFactory;	

	private Session openSession;
	
	@PostConstruct
	public void init()
	{
		openSession = sessionFactory.openSession();
	}
	
	@Override
	public List<Customer> getCustomers() 
	{		
		Query<Customer> theQuery = openSession.createQuery("from Customer order by lastName", Customer.class);
		
		List<Customer> listCustomers = theQuery.getResultList();
		
		return listCustomers;
	}

	@Override
	public Customer getCustomer(int theId) 
	{
		return openSession.find(Customer.class, theId);
	}

	@Override
	public void saveCustomer(Customer theCustomer) 
	{
		openSession.save(theCustomer);
	}

	@Override
	public void deleteCustomer(int theId) {
		// TODO Auto-generated method stub
		
	}

}
