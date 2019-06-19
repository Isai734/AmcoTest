package com.amco.tv.model.cast;

import com.squareup.moshi.Json;

public class Cast{

	@Json(name = "voice")
	private boolean voice;

	@Json(name = "character")
	private Character character;

	@Json(name = "person")
	private Person person;

	@Json(name = "self")
	private boolean self;

	public void setVoice(boolean voice){
		this.voice = voice;
	}

	public boolean isVoice(){
		return voice;
	}

	public void setCharacter(Character character){
		this.character = character;
	}

	public Character getCharacter(){
		return character;
	}

	public void setPerson(Person person){
		this.person = person;
	}

	public Person getPerson(){
		return person;
	}

	public void setSelf(boolean self){
		this.self = self;
	}

	public boolean isSelf(){
		return self;
	}

	@Override
 	public String toString(){
		return 
			"Cast{" + 
			"voice = '" + voice + '\'' + 
			",character = '" + character + '\'' + 
			",person = '" + person + '\'' + 
			",self = '" + self + '\'' + 
			"}";
		}
}