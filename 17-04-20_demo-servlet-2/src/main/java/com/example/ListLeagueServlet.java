package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.League;

public class ListLeagueServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private List<League> listLeague = null;
	
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
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		listLeague = new ArrayList<League>();
		listLeague.add(new League(UUID.randomUUID().toString(), "Summer", 2020, "Duke's Soccer League"));
		listLeague.add(new League(UUID.randomUUID().toString(), "Autumn", 2020, "English Premere League"));
		listLeague.add(new League(UUID.randomUUID().toString(), "Winter", 2020, "Beach Volley League"));
		out.println("<html><head><title>list all league</title></head><body><table border='1'><tr><td>League ID</td>"
				+ "<td>League Title</td><td>League Year</td><td>Season</td></tr>");
		for(League l : listLeague)
		{
			out.println("<tr><td>"+l.getLeagueID()+"</td><td>"+l.getLeagueTitle()+"</td><td>"
					+l.getLeagueYear()+"</td><td>"+l.getLeagueSeason()+"</td></tr>");
		}
		out.println("</table></body></html>");
	}
}
