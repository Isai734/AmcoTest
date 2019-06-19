package com.amco.tv.model.program;

import com.squareup.moshi.Json;

public class Country{

	@Json(name = "code")
	private String code;

	@Json(name = "timezone")
	private String timezone;

	@Json(name = "name")
	private String name;

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setTimezone(String timezone){
		this.timezone = timezone;
	}

	public String getTimezone(){
		return timezone;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"Country{" + 
			"code = '" + code + '\'' + 
			",timezone = '" + timezone + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}