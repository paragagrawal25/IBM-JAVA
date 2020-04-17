package com.example.model;

public class League 
{
	private String leagueID;
	private String leagueTitle;
	private int leagueYear;
	private String leagueSeason;
	
	public League()
	{
		
	}
	
	public League(String leagueID, String leagueTitle, int leagueYear, String leagueSeason) 
	{
		this.leagueID = leagueID;
		this.leagueTitle = leagueTitle;
		this.leagueYear = leagueYear;
		this.leagueSeason = leagueSeason;
	}
	
	public String getLeagueID() {
		return leagueID;
	}
	public void setLeagueID(String leagueID) {
		this.leagueID = leagueID;
	}
	
	public String getLeagueTitle() {
		return leagueTitle;
	}
	public void setLeagueTitle(String leagueTitle) {
		this.leagueTitle = leagueTitle;
	}
	
	public int getLeagueYear() {
		return leagueYear;
	}
	public void setLeagueYear(int leagueYear) {
		this.leagueYear = leagueYear;
	}
	
	public String getLeagueSeason() {
		return leagueSeason;
	}
	public void setLeagueSeason(String leagueSeason) {
		this.leagueSeason = leagueSeason;
	}
}
