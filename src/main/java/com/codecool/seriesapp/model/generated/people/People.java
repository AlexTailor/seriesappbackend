package com.codecool.seriesapp.model.generated.people;

import com.fasterxml.jackson.annotation.JsonProperty;

public class People{

	@JsonProperty("birthday")
	private String birthday;

	@JsonProperty("country")
	private Country country;

	@JsonProperty("image")
	private Image image;

	@JsonProperty("gender")
	private String gender;

	@JsonProperty("_links")
	private Links links;

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private int id;

	@JsonProperty("deathday")
	private Object deathday;

	@JsonProperty("url")
	private String url;

	public String getBirthday(){
		return birthday;
	}

	public Country getCountry(){
		return country;
	}

	public Image getImage(){
		return image;
	}

	public String getGender(){
		return gender;
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

	public Object getDeathday(){
		return deathday;
	}

	public String getUrl(){
		return url;
	}
}