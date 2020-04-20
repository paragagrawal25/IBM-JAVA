package com.example.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection 
{
	public static Connection initializeConnection() throws SQLException
	{
		String dbURL = "jdbc:mysql://localhost:3306/test";
		String dbUsername = "root";
		String dbPassword = "admin123@";
		
		Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
		
		return conn;
	}
}
