package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.InstructorDetails;

public interface InstructorDetailsService 
{
	public void createInstructorDetails(InstructorDetails instructorDetails);

	public List<InstructorDetails> getAllInstructorsDetails();
	
	public void deleteInstInstructorDetails(int instructorDetailsID);
	
	public InstructorDetails getInstInstructorsDetailsByID(int instructorDetailsID);
	
	public void updateInstInstructorsDetailsByID(InstructorDetails instructorDetails, Long instructorDetailsID);
}
