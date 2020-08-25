package com.codecool.seriesapp.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CastItem{

	@JsonProperty("voice")
	private boolean voice;

	@JsonProperty("character")
	private Character character;

	@JsonProperty("person")
	private Person person;

	@JsonProperty("self")
	private boolean self;

	public boolean isVoice(){
		return voice;
	}

	public Character getCharacter(){
		return character;
	}

	public Person getPerson(){
		return person;
	}

	public boolean isSelf(){
		return self;
	}
}