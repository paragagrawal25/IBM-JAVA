package com.example.demo.bean;

import java.util.Formattable;
import java.util.Formatter;

public class DailyFortuneService implements FortuneService, Formattable
{

	public void formatTo(Formatter formatter, int flags, int width, int precision) {
		// TODO Auto-generated method stub
		
	}

	public String getFortune() {
		// TODO Auto-generated method stub
		return "Today is your lucky day";
	}
	
}
