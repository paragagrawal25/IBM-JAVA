package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.DAO.InstructorDAO;
import com.example.demo.entity.Instructor;

@Service
public class InstructorServiceImpl implements InstructorService
{
	@Autowired
	private InstructorDAO refInstructorDAO;
	
	@Override
	@Transactional
	public void createInstructor(Instructor instructor) 
	{
		refInstructorDAO.createInstructor(instructor);
	}

	@Override
	@Transactional
	public List<Instructor> getAllInstructors() 
	{
		return refInstructorDAO.getAllInstructors();
	}
}
