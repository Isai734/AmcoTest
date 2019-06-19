package com.amco.tv.model.program;

import java.util.List;
import com.squareup.moshi.Json;

public class Schedule{

	@Json(name = "days")
	private List<String> days;

	@Json(name = "time")
	private String time;

	public void setDays(List<String> days){
		this.days = days;
	}

	public List<String> getDays(){
		return days;
	}

	public void setTime(String time){
		this.time = time;
	}

	public String getTime(){
		return time;
	}

	@Override
 	public String toString(){
		return 
			"Schedule{" + 
			"days = '" + days + '\'' + 
			",time = '" + time + '\'' + 
			"}";
		}
}