package com.codecool.seriesapp.model.generated;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Schedule{

	@JsonProperty("days")
	private List<String> days;

	@JsonProperty("time")
	private String time;

	public List<String> getDays(){
		return days;
	}

	public String getTime(){
		return time;
	}
}