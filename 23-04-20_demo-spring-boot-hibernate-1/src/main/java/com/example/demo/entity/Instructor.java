package com.example.demo.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "instructor")
public class Instructor 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String emailID;

	@JsonBackReference
	@JoinColumn(name = "instructor_details_id")
	@OneToOne(cascade = CascadeType.ALL)
	private InstructorDetails instructorDetails;

	public Instructor() 
	{
	
	}

	public Instructor(String firstName, String lastName, String emailID, InstructorDetails instructorDetails) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailID = emailID;
		this.instructorDetails = instructorDetails;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	
	public InstructorDetails getInstructorDetails() {
		return instructorDetails;
	}

	public void setInstructorDetails(InstructorDetails instructorDetails) {
		this.instructorDetails = instructorDetails;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailID=" + emailID
				+ ", instructorDetails=" + instructorDetails + "]";
	}
}
