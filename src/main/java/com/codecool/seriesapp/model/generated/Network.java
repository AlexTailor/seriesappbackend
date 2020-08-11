package com.codecool.seriesapp.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Network{

	@JsonProperty("country")
	private Country country;

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private int id;

	public Country getCountry(){
		return country;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}
}