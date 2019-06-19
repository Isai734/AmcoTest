package com.amco.tv.model.cast;

import com.squareup.moshi.Json;

public class Links{

	@Json(name = "self")
	private Self self;

	public void setSelf(Self self){
		this.self = self;
	}

	public Self getSelf(){
		return self;
	}

	@Override
 	public String toString(){
		return 
			"Links{" + 
			"self = '" + self + '\'' + 
			"}";
		}
}