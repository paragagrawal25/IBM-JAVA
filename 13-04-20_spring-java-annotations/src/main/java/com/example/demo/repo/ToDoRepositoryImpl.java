package com.example.demo.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.ToDo;

@Repository
public class ToDoRepositoryImpl implements ToDoRepository
{
	private DataSource dataSource;
	private Connection connection = null;
	
	private static Logger logger = Logger.getLogger("ToDoRepositoryImpl");
	
	@Autowired
	public ToDoRepositoryImpl(DataSource dataSource) throws SQLException
	{
		super();
		logger.log(Level.INFO,"connecting to database");
		connection = dataSource.getConnection();
		logger.log(Level.INFO,"connected");
		this.dataSource = dataSource;
	}

	@Override
	public ToDo createToDo(ToDo toDo) 
	{
		try
		{
			PreparedStatement pStatement = connection.prepareStatement("insert into ToDo value(?,?)");
			pStatement.setString(1, toDo.getToDoID());
			pStatement.setString(2, toDo.getToDoName());
			pStatement.executeUpdate();
			logger.log(Level.INFO, "ToDo Creation Completed");
		}
		catch(Exception e)
		{
			logger.log(Level.INFO, "Unable to Connect DB");
			e.printStackTrace();
		}
		return toDo;
	}

	@Override
	public List<ToDo> getAllToDos() 
	{
		PreparedStatement pStatement;
		List<ToDo> toDoList = new ArrayList<ToDo>();
		try 
		{
			pStatement = connection.prepareStatement("select * from todo");
			ResultSet result = pStatement.executeQuery();
			result.last();
			int rowCnt = result.getRow();
			System.out.println(rowCnt);
			
			toDoList.clear();
			while(result.next())
			{
				String toDoID = result.getString(1);
				String toDoName = result.getString(2);
				ToDo toDo = new ToDo(toDoID,toDoName);
				toDoList.add(toDo);
			}
		} 
		catch (SQLException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return toDoList;
	}

}
