package com.example.demo.DAO;

import java.util.List;

import com.example.demo.entity.Instructor;

public interface InstructorDAO 
{
	public void createInstructor(Instructor instructor);

	public List<Instructor> getAllInstructors();
}
