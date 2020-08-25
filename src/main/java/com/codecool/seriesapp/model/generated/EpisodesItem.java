package com.codecool.seriesapp.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EpisodesItem{

	@JsonProperty("summary")
	private String summary;

	@JsonProperty("number")
	private int number;

	@JsonProperty("airtime")
	private String airtime;

	@JsonProperty("image")
	private Image image;

	@JsonProperty("_links")
	private Links links;

	@JsonProperty("airdate")
	private String airdate;

	@JsonProperty("name")
	private String name;

	@JsonProperty("season")
	private int season;

	@JsonProperty("runtime")
	private int runtime;

	@JsonProperty("airstamp")
	private String airstamp;

	@JsonProperty("id")
	private int id;

	@JsonProperty("url")
	private String url;

	public String getSummary(){
		return summary;
	}

	public int getNumber(){
		return number;
	}

	public String getAirtime(){
		return airtime;
	}

	public Image getImage(){
		return image;
	}

	public Links getLinks(){
		return links;
	}

	public String getAirdate(){
		return airdate;
	}

	public String getName(){
		return name;
	}

	public int getSeason(){
		return season;
	}

	public int getRuntime(){
		return runtime;
	}

	public String getAirstamp(){
		return airstamp;
	}

	public int getId(){
		return id;
	}

	public String getUrl(){
		return url;
	}
}