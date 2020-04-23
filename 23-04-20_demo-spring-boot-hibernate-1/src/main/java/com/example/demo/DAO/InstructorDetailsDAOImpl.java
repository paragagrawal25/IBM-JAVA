package com.example.demo.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetails;

@Repository("instructorDetailsDAO")
public class InstructorDetailsDAOImpl implements InstructorDetailsDAO
{
	private EntityManager entityManager;

	@Autowired
	public InstructorDetailsDAOImpl(EntityManager entityManager) 
	{
		this.entityManager = entityManager;
	}
	
	public void init()
	{
		
	}

	@Override
	public void createInstructorDetails(InstructorDetails instructorDetails) 
	{
		Session session = entityManager.unwrap(Session.class);
		Instructor instructor = instructorDetails.getInstructor();
		instructor.setInstructorDetails(instructorDetails);
		session.save(instructor);
	}

	@Override
	public List<InstructorDetails> getAllInstructorsDetails() 
	{
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("from InstructorDetails",InstructorDetails.class);
		return query.getResultList();
	}

	@Override
	public void deleteInstInstructorDetails(int instructorDetailsID) 
	{
		Session session = entityManager.unwrap(Session.class);
		InstructorDetails insDetails = getInstInstructorsDetailsByID(instructorDetailsID);
		if(insDetails != null)
		{
			session.delete(insDetails);
		}
	}

	@Override
	public InstructorDetails getInstInstructorsDetailsByID(int instructorDetailsID) 
	{
		Session session = entityManager.unwrap(Session.class);
		return session.find(InstructorDetails.class, instructorDetailsID);
	}

	@Override
	public void updateInstInstructorsDetailsByID(InstructorDetails instructorDetails, Long instructorDetailsID) 
	{
		Session session = entityManager.unwrap(Session.class);
		//SessionFactory factory = entityManager.unwrap(SessionFactory.class);
		//Session session = factory.openSession();
		//InstructorDetails insDetails = getInstInstructorsDetailsByID(instructorDetailsID);
		Instructor ins = instructorDetails.getInstructor();
		ins.setInstructorDetails(instructorDetails);
		if(ins != null)
		{
			session.evict(ins);
			session.update(ins);
		}
	}
}
