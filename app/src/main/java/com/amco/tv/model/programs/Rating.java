package com.amco.tv.model.programs;

import com.squareup.moshi.Json;

public class Rating{

	@Json(name = "average")
	private Object average;

	public void setAverage(Object average){
		this.average = average;
	}

	public Object getAverage(){
		return average;
	}

	@Override
 	public String toString(){
		return 
			"Rating{" + 
			"average = '" + average + '\'' + 
			"}";
		}
}