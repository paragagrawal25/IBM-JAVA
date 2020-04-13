package com.example.demo.bean;

import lombok.Setter;

@Setter
public class BaseBallCoach implements Coach
{
	private FortuneService fortuneService;

	public String getDailyWorkout() 
	{
		return "Practice Baseball Today";
	}

	public String getDailyFortune() 
	{
		return fortuneService.getFortune();
	}
	
}
