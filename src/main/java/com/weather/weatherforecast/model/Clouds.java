package com.weather.weatherforecast.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Clouds {
	@JsonProperty("all")
	private long all;

	public long getAll() {
		return all;
	}

	public void setAll(long all) {
		this.all = all;
	}

}
