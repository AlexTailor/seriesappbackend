package com.codecool.seriesapp.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Character{

	@JsonProperty("image")
	private Image image;

	@JsonProperty("_links")
	private Links links;

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private int id;

	@JsonProperty("url")
	private String url;

	public Image getImage(){
		return image;
	}

	public Links getLinks(){
		return links;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public String getUrl(){
		return url;
	}
}