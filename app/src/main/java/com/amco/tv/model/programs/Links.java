package com.amco.tv.model.programs;

import com.squareup.moshi.Json;

public class Links{

	@Json(name = "self")
	private Self self;

	@Json(name = "previousepisode")
	private Previousepisode previousepisode;

	public void setSelf(Self self){
		this.self = self;
	}

	public Self getSelf(){
		return self;
	}

	public void setPreviousepisode(Previousepisode previousepisode){
		this.previousepisode = previousepisode;
	}

	public Previousepisode getPreviousepisode(){
		return previousepisode;
	}

	@Override
 	public String toString(){
		return 
			"Links{" + 
			"self = '" + self + '\'' + 
			",previousepisode = '" + previousepisode + '\'' + 
			"}";
		}
}