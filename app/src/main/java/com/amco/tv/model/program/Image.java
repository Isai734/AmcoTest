package com.amco.tv.model.program;

import com.squareup.moshi.Json;

public class Image{

	@Json(name = "original")
	private String original;

	@Json(name = "medium")
	private String medium;

	public void setOriginal(String original){
		this.original = original;
	}

	public String getOriginal(){
		return original;
	}

	public void setMedium(String medium){
		this.medium = medium;
	}

	public String getMedium(){
		return medium;
	}

	@Override
 	public String toString(){
		return 
			"Image{" + 
			"original = '" + original + '\'' + 
			",medium = '" + medium + '\'' + 
			"}";
		}
}