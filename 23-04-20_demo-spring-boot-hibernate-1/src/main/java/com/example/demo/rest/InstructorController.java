package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Instructor;
import com.example.demo.service.InstructorService;

@RestController
@RequestMapping("/api")
public class InstructorController 
{
	@Autowired
	private InstructorService refInstructorService;
	
	@PostMapping("/instructors")
	public void createInstructor(@RequestBody Instructor theInstructor)
	{
		refInstructorService.createInstructor(theInstructor);
	}
	
	@GetMapping("/instructors")
	public List<Instructor> getAllInstructors()
	{
		return refInstructorService.getAllInstructors();
	}
}
