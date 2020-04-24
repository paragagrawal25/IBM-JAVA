package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "project_name")
public class Project 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String desc;
	private String agentName;
	
	public Project()
	{
		
	}

	public Project(String name, String desc, String agentName) {
		super();
		this.name = name;
		this.desc = desc;
		this.agentName = agentName;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
}
