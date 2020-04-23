package com.example.demo.DAO;

import java.util.List;

import com.example.demo.entity.InstructorDetails;

public interface InstructorDetailsDAO 
{
	public void createInstructorDetails(InstructorDetails instructorDetails);

	public List<InstructorDetails> getAllInstructorsDetails();

	public void deleteInstInstructorDetails(int instructorDetailsID);

	public InstructorDetails getInstInstructorsDetailsByID(int instructorDetailsID);

	public void updateInstInstructorsDetailsByID(InstructorDetails instructorDetails, Long instructorDetailsID);
}
