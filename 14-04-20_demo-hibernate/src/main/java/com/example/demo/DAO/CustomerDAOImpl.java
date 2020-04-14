package com.example.demo.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.demo.entity.Customer;
import com.example.demo.factory.MyHibernateFactory;

public class CustomerDAOImpl implements CustomerDAO 
{
	private MyHibernateFactory factory = null;
	private SessionFactory sessionFactory = null;
	private Session session = null;
	private Transaction transaction;
	
	{
		factory = new MyHibernateFactory();
		sessionFactory = factory.getSessionFactory();
		session = sessionFactory.getCurrentSession();
		transaction = session.getTransaction();
	}
	
	@Override
	public Customer createCustomer(Customer customer) 
	{
		transaction.begin();
		session.save(customer);
		transaction.commit();
		return customer;
	}

	@Override
	public List<Customer> getAllCustomers() 
	{
		transaction.begin();
		List<Customer> listCustomer = session.createQuery("from Customer",Customer.class).list();
		transaction.commit();
		return listCustomer;
	}

	@Override
	public Customer getCustomerByID(String customerID) 
	{
		return session.get(Customer.class,customerID);
	}

}
