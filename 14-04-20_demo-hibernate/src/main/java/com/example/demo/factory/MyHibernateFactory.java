package com.example.demo.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.demo.entity.Customer;

public class MyHibernateFactory 
{
	private SessionFactory sessionFactory;
	
	private static MyHibernateFactory factory;

	public MyHibernateFactory() 
	{
		
	}
	
	public SessionFactory getSessionFactory()
	{
		sessionFactory = new Configuration().configure().addAnnotatedClass(Customer.class).buildSessionFactory();
		return sessionFactory;
	}
	
	public static MyHibernateFactory getMyHibernateFactory()
	{
		if(factory == null)
		{
			factory = new MyHibernateFactory();
		}
		return factory;
	}
}
