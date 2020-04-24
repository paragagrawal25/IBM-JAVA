package com.example.demo.dto;

public class ProjectQueryDTO 
{
	private String name;
	//private String desc;
	private String agentName;
	
	public ProjectQueryDTO() 
	{
	
	}
	
	public ProjectQueryDTO(String name, String agentName) {
		super();
		this.name = name;
		this.agentName = agentName;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/*public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}*/
	
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
}
