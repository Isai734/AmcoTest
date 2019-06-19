package com.amco.tv.model.program;

import com.squareup.moshi.Json;

public class Externals{

	@Json(name = "thetvdb")
	private String thetvdb;

	@Json(name = "imdb")
	private String imdb;

	@Json(name = "tvrage")
	private String tvrage;

	public void setThetvdb(String thetvdb){
		this.thetvdb = thetvdb;
	}

	public String getThetvdb(){
		return thetvdb;
	}

	public void setImdb(String imdb){
		this.imdb = imdb;
	}

	public String getImdb(){
		return imdb;
	}

	public void setTvrage(String tvrage){
		this.tvrage = tvrage;
	}

	public String getTvrage(){
		return tvrage;
	}

	@Override
 	public String toString(){
		return 
			"Externals{" + 
			"thetvdb = '" + thetvdb + '\'' + 
			",imdb = '" + imdb + '\'' + 
			",tvrage = '" + tvrage + '\'' + 
			"}";
		}
}