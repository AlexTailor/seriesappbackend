package com.codecool.seriesapp.model.generated;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Embedded{

	@JsonProperty("cast")
	private List<CastItem> cast;

	@JsonProperty("episodes")
	private List<EpisodesItem> episodes;

	public List<CastItem> getCast(){
		return cast;
	}

	public List<EpisodesItem> getEpisodes(){
		return episodes;
	}
}