package com.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.League;

public class AddLeagueServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private List<League> addListLeague = null;

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
		
		String leagueTitle = req.getParameter("league_title");
		int leagueYear = Integer.parseInt(req.getParameter("league_year"));
		String leagueSeason = req.getParameter("league_season");
		
		League league = new League(UUID.randomUUID().toString(),leagueTitle,leagueYear,leagueSeason);
		addListLeague = new ArrayList<>();
		addListLeague.add(league);
		
		System.out.println(addListLeague);
	}
}
