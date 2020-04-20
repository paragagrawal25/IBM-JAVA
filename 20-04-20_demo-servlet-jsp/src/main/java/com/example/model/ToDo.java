package com.example.model;

public class ToDo 
{
	private int toDoID;
	private String toDoName;
	private String toDoCompletedBy;
	
	public ToDo() 
	{
	
	}
	
	public ToDo(int toDoID, String toDoName, String toDoCompletedBy) 
	{
		this.toDoID = toDoID;
		this.toDoName = toDoName;
		this.toDoCompletedBy = toDoCompletedBy;
	}
	
	public int getToDoID() {
		return toDoID;
	}
	public void setToDoID(int toDoID) {
		this.toDoID = toDoID;
	}
	
	public String getToDoName() {
		return toDoName;
	}
	public void setToDoName(String toDoName) {
		this.toDoName = toDoName;
	}
	
	public String getToDoCompletedBy() {
		return toDoCompletedBy;
	}
	public void setToDoCompletedBy(String toDoCompletedBy) {
		this.toDoCompletedBy = toDoCompletedBy;
	}
}
