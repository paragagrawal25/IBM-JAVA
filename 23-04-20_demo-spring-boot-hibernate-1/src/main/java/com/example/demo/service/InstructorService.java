package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Instructor;

public interface InstructorService 
{
	public void createInstructor(Instructor instructor);
	
	public List<Instructor> getAllInstructors();
}
