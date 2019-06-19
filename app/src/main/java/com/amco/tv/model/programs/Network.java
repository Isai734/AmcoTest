package com.amco.tv.model.programs;

import com.squareup.moshi.Json;

public class Network{

	@Json(name = "country")
	private Country country;

	@Json(name = "name")
	private String name;

	@Json(name = "id")
	private int id;

	public void setCountry(Country country){
		this.country = country;
	}

	public Country getCountry(){
		return country;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"Network{" + 
			"country = '" + country + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}