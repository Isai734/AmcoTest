package com.amco.tv.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.Moshi;

import java.io.IOException;

public class ResponseError{


	@Json(name = "code")
	private int code;

	@Json(name = "name")
	private String name;

	@Json(name = "message")
	private String message;

	@Json(name = "status")
	private int status;

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	public static ResponseError fromResponseBody(String responseBody) throws IOException {
		Moshi moshi = new Moshi.Builder()
				.build();
		return moshi.adapter(ResponseError.class).fromJson(responseBody);
	}

	public ResponseError(int code, String name, String message, int status) {
		this.code = code;
		this.name = name;
		this.message = message;
		this.status = status;
	}

	@Override
 	public String toString(){
		return 
			"ResponseError{" + 
			"code = '" + code + '\'' + 
			",name = '" + name + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}