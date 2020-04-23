package com.example.demo.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Instructor;

@Repository("instructorDAO")
public class InstructorDAOImpl implements InstructorDAO
{
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void createInstructor(Instructor instructor) 
	{
		Session session = entityManager.unwrap(Session.class);
		session.save(instructor);
	}

	@Override
	public List<Instructor> getAllInstructors() 
	{
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("from Instructor",Instructor.class);
		List<Instructor> instructorsList = query.getResultList();
		return instructorsList;
	}
}
