package com.codecool.seriesapp.model.generated;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Series{

	@JsonProperty("summary")
	private String summary;

	@JsonProperty("image")
	private Image image;

	@JsonProperty("_links")
	private Links links;

	@JsonProperty("premiered")
	private String premiered;

	@JsonProperty("rating")
	private Rating rating;

	@JsonProperty("runtime")
	private int runtime;

	@JsonProperty("weight")
	private int weight;

	@JsonProperty("language")
	private String language;

	@JsonProperty("type")
	private String type;

	@JsonProperty("url")
	private String url;

	@JsonProperty("officialSite")
	private String officialSite;

	@JsonProperty("network")
	private Network network;

	@JsonProperty("schedule")
	private Schedule schedule;

	@JsonProperty("webChannel")
	private Object webChannel;

	@JsonProperty("_embedded")
	private Embedded embedded;

	@JsonProperty("genres")
	private List<String> genres;

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private int id;

	@JsonProperty("externals")
	private Externals externals;

	@JsonProperty("updated")
	private int updated;

	@JsonProperty("status")
	private String status;

	public String getSummary(){
		return summary;
	}

	public Image getImage(){
		return image;
	}

	public Links getLinks(){
		return links;
	}

	public String getPremiered(){
		return premiered;
	}

	public Rating getRating(){
		return rating;
	}

	public int getRuntime(){
		return runtime;
	}

	public int getWeight(){
		return weight;
	}

	public String getLanguage(){
		return language;
	}

	public String getType(){
		return type;
	}

	public String getUrl(){
		return url;
	}

	public String getOfficialSite(){
		return officialSite;
	}

	public Network getNetwork(){
		return network;
	}

	public Schedule getSchedule(){
		return schedule;
	}

	public Object getWebChannel(){
		return webChannel;
	}

	public Embedded getEmbedded(){
		return embedded;
	}

	public List<String> getGenres(){
		return genres;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public Externals getExternals(){
		return externals;
	}

	public int getUpdated(){
		return updated;
	}

	public String getStatus(){
		return status;
	}
}