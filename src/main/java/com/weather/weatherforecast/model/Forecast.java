package com.weather.weatherforecast.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Forecast {

	@JsonProperty("dt")
	private long date;

	@JsonProperty("main")
	private Main main;

	@JsonProperty("weather")
	private List<Weather> weathers;

	@JsonProperty("clouds")
	private Clouds clouds;

	@JsonProperty("wind")
	private Winds winds;

	@JsonProperty("visibility")
	private long visibility;

	@JsonProperty("pop")
	private long pop;

	@JsonProperty("sys")
	private SystemDetails systemDetails;

	@JsonProperty("dt_txt")
	private String dateText;

	@JsonProperty("forecast_summary")
	private String forecastSummary;

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public List<Weather> getWeathers() {
		return weathers;
	}

	public void setWeathers(List<Weather> weathers) {
		this.weathers = weathers;
	}

	public Clouds getClouds() {
		return clouds;
	}

	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}

	public Winds getWinds() {
		return winds;
	}

	public void setWinds(Winds winds) {
		this.winds = winds;
	}

	public long getVisibility() {
		return visibility;
	}

	public void setVisibility(long visibility) {
		this.visibility = visibility;
	}

	public long getPop() {
		return pop;
	}

	public void setPop(long pop) {
		this.pop = pop;
	}

	public SystemDetails getSystemDetails() {
		return systemDetails;
	}

	public void setSystemDetails(SystemDetails systemDetails) {
		this.systemDetails = systemDetails;
	}

	public String getDateText() {
		return dateText;
	}

	public void setDateText(String dateText) {
		this.dateText = dateText;
	}

	public String getForecastSummary() {
		return forecastSummary;
	}

	public void setForecastSummary(String forecastSummary) {
		this.forecastSummary = forecastSummary;
	}
	
	

}