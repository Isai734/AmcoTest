package com.amco.tv.model.programs;

import com.squareup.moshi.Json;

public class Self{

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
			"Self{" + 
			"href = '" + href + '\'' + 
			"}";
		}
}