package com.weather.weatherforecast.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherForecastResponse {
	
	@JsonProperty("cod")
	private int responseCode;

	@JsonProperty("message")
	private String message;

	@JsonProperty("cnt")
	private int count;

	@JsonProperty("list")
	private List<Forecast> forecasts;

	@JsonProperty("city")
	private City city;

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<Forecast> getForecasts() {
		return forecasts;
	}

	public void setForecasts(List<Forecast> forecasts) {
		this.forecasts = forecasts;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

		
	
}
