package com.example.demo.bean;

import org.springframework.stereotype.Component;

@Component
public class ToDo 
{
	private String toDoID;
	private String toDoName;
	
	public ToDo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ToDo(String toDoID, String toDoName) {
		super();
		this.toDoID = toDoID;
		this.toDoName = toDoName;
	}
	
	public String getToDoID() {
		return toDoID;
	}
	public void setToDoID(String toDoID) {
		this.toDoID = toDoID;
	}
	
	public String getToDoName() {
		return toDoName;
	}
	public void setToDoName(String toDoName) {
		this.toDoName = toDoName;
	}
	
	@Override
	public String toString() {
		return "ToDo [toDoID=" + toDoID + ", toDoName=" + toDoName + "]";
	}
}
