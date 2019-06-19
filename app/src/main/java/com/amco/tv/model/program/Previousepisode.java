package com.amco.tv.model.program;

import com.squareup.moshi.Json;

public class Previousepisode{

	@Json(name = "href")
	private String href;

	public void setHref(String href){
		this.href = href;
	}

	public String getHref(){
		return href;
	}

	@Override
 	public String toString(){
		return 
			"Previousepisode{" + 
			"href = '" + href + '\'' + 
			"}";
		}
}