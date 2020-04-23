package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "instructor_details")
public class InstructorDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "course_taught")
	private String courseTaught;
	
	@Column(name = "specialization")
	private String specialization;
	
	@JsonManagedReference
	
	@OneToOne(mappedBy = "instructorDetails", cascade = CascadeType.ALL)
	private Instructor instructor;

	public InstructorDetails() 
	{
	
	}

	public InstructorDetails(String courseTaught, String specialization, Instructor instructor) 
	{
		this.courseTaught = courseTaught;
		this.specialization = specialization;
		this.instructor = instructor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseTaught() {
		return courseTaught;
	}

	public void setCourseTaught(String courseTaught) {
		this.courseTaught = courseTaught;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "InstructorDetails [id=" + id + ", courseTaught=" + courseTaught + ", specialization=" + specialization
				+ ", instructor=" + instructor + "]";
	}
}
