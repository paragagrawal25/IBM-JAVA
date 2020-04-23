package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.InstructorDetails;
import com.example.demo.service.InstructorDetailsService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api")
@Api(value = "Employee Management System", description = "Operations pertaining to employee in Employee Management System")
public class InstructorDetailsController 
{
	@Autowired
	private InstructorDetailsService refInstructorDetailsService;
	
	@PostMapping("/instructors_details")
	public void createInstructorDetails(@RequestBody InstructorDetails instructorDetails)
	{
		refInstructorDetailsService.createInstructorDetails(instructorDetails);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/instructors_details")
	public List<InstructorDetails> getAllInstructorsDetails()
	{
		return refInstructorDetailsService.getAllInstructorsDetails();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/instructors_details/{instructorDetailsID}")
	public InstructorDetails getInstructorsDetailsByID(@PathVariable int instructorDetailsID)
	{
		return refInstructorDetailsService.getInstInstructorsDetailsByID(instructorDetailsID);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/instructors_details/{instructorDetailsID}")
	public void deleteInstructorsDetails(@PathVariable int instructorDetailsID)
	{
		refInstructorDetailsService.deleteInstInstructorDetails(instructorDetailsID);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/instructors_details/{instructorDetailsID}")
	public void updateInstructorsDetails(@RequestBody InstructorDetails instructorDetails, @PathVariable Long instructorDetailsID)
	{
		refInstructorDetailsService.updateInstInstructorsDetailsByID(instructorDetails, instructorDetailsID);
	}
}
