package com.amco.tv.model.cast;

import com.squareup.moshi.Json;

public class Character{

	@Json(name = "image")
	private Object image;

	@Json(name = "_links")
	private Links links;

	@Json(name = "name")
	private String name;

	@Json(name = "id")
	private int id;

	@Json(name = "url")
	private String url;

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

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"Character{" + 
			"image = '" + image + '\'' + 
			",_links = '" + links + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}