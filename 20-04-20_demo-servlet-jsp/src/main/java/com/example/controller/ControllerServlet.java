package com.example.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.connection.DatabaseConnection;

public class ControllerServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private List<String> errorsList;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		errorsList = new ArrayList<>();
		String toDoName = req.getParameter("toDoName");
		int toDoID = 0;
		if(toDoName.length() < 6)
		{
			errorsList.add("Invalid ToDo Name");
		}
		try
		{
			toDoID = Integer.parseInt(req.getParameter("toDoID"));
		}
		catch(Exception e)
		{
			errorsList.add("ToDo ID must be Numeric");
		}
		String compBy = req.getParameter("compBy");
		if(compBy.length()<=0)
		{
			errorsList.add("Completed By Field cannot be Blank");
		}
		
		if(errorsList.isEmpty())
		{
			//ToDo toDo = new ToDo(toDoID,toDoName,compBy);
			//req.setAttribute("toDo", toDo);
			
			try 
			{
				Connection connection = DatabaseConnection.initializeConnection();
				
				PreparedStatement pStatement = connection.prepareStatement("insert into todo values(?,?,?)");
				
				pStatement.setInt(1, toDoID);
				pStatement.setString(2, toDoName);
				pStatement.setString(3, compBy);
				
				pStatement.executeUpdate();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("success.jsp");
			dispatcher.forward(req, resp);
		}
		else
		{
			req.setAttribute("errorsList", errorsList);
			RequestDispatcher dispatcher = req.getRequestDispatcher("error.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
