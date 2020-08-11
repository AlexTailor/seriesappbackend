package com.codecool.seriesapp.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Externals{

	@JsonProperty("thetvdb")
	private int thetvdb;

	@JsonProperty("imdb")
	private String imdb;

	@JsonProperty("tvrage")
	private int tvrage;

	public int getThetvdb(){
		return thetvdb;
	}

	public String getImdb(){
		return imdb;
	}

	public int getTvrage(){
		return tvrage;
	}
}