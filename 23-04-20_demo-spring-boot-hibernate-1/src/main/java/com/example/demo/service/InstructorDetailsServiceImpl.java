package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.DAO.InstructorDetailsDAO;
import com.example.demo.entity.InstructorDetails;

@Service
public class InstructorDetailsServiceImpl implements InstructorDetailsService
{
	@Autowired
	private InstructorDetailsDAO refInstructorDetailsDAO;

	@Override
	@Transactional
	public void createInstructorDetails(InstructorDetails instructorDetails) 
	{
		refInstructorDetailsDAO.createInstructorDetails(instructorDetails);
	}

	@Override
	@Transactional
	public List<InstructorDetails> getAllInstructorsDetails() 
	{
		return refInstructorDetailsDAO.getAllInstructorsDetails();
	}

	@Override
	@Transactional
	public void deleteInstInstructorDetails(int instructorDetailsID) 
	{
		refInstructorDetailsDAO.deleteInstInstructorDetails(instructorDetailsID);
	}

	@Override
	@Transactional
	public InstructorDetails getInstInstructorsDetailsByID(int instructorDetailsID) 
	{
		return refInstructorDetailsDAO.getInstInstructorsDetailsByID(instructorDetailsID);
	}

	@Override
	@Transactional
	public void updateInstInstructorsDetailsByID(InstructorDetails instructorDetails, Long instructorDetailsID) 
	{
		refInstructorDetailsDAO.updateInstInstructorsDetailsByID(instructorDetails, instructorDetailsID);
	}

}
