package com.codecool.seriesapp.model.generated.people;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Country{

	@JsonProperty("code")
	private String code;

	@JsonProperty("timezone")
	private String timezone;

	@JsonProperty("name")
	private String name;

	public String getCode(){
		return code;
	}

	public String getTimezone(){
		return timezone;
	}

	public String getName(){
		return name;
	}
}