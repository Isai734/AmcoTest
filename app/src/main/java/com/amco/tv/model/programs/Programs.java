package com.amco.tv.model.programs;

import com.squareup.moshi.Json;

public class Programs{

	@Json(name = "summary")
	private String summary;

	@Json(name = "image")
	private Object image;

	@Json(name = "_links")
	private Links links;

	@Json(name = "airdate")
	private String airdate;

	@Json(name = "show")
	private Show show;

	@Json(name = "runtime")
	private String runtime;

	@Json(name = "airstamp")
	private String airstamp;

	@Json(name = "url")
	private String url;

	@Json(name = "number")
	private int number;

	@Json(name = "airtime")
	private String airtime;

	@Json(name = "name")
	private String name;

	@Json(name = "season")
	private int season;

	@Json(name = "id")
	private int id;

	public void setSummary(String summary){
		this.summary = summary;
	}

	public String getSummary(){
		return summary;
	}

	public void setImage(Object image){
		this.image = image;
	}

	public Object getImage(){
		return image;
	}

	public void setLinks(Links links){
		this.links = links;
	}

	public Links getLinks(){
		return links;
	}

	public void setAirdate(String airdate){
		this.airdate = airdate;
	}

	public String getAirdate(){
		return airdate;
	}

	public void setShow(Show show){
		this.show = show;
	}

	public Show getShow(){
		return show;
	}

	public void setRuntime(String runtime){
		this.runtime = runtime;
	}

	public String getRuntime(){
		return runtime;
	}

	public void setAirstamp(String airstamp){
		this.airstamp = airstamp;
	}

	public String getAirstamp(){
		return airstamp;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setNumber(int number){
		this.number = number;
	}

	public int getNumber(){
		return number;
	}

	public void setAirtime(String airtime){
		this.airtime = airtime;
	}

	public String getAirtime(){
		return airtime;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setSeason(int season){
		this.season = season;
	}

	public int getSeason(){
		return season;
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
			"Programs{" + 
			"summary = '" + summary + '\'' + 
			",image = '" + image + '\'' + 
			",_links = '" + links + '\'' + 
			",airdate = '" + airdate + '\'' + 
			",show = '" + show + '\'' + 
			",runtime = '" + runtime + '\'' + 
			",airstamp = '" + airstamp + '\'' + 
			",url = '" + url + '\'' + 
			",number = '" + number + '\'' + 
			",airtime = '" + airtime + '\'' + 
			",name = '" + name + '\'' + 
			",season = '" + season + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}