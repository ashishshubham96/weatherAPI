package com.weather.weatherforecast.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Main {
	@JsonProperty("temp")
	private double temperature;

	@JsonProperty("feels_like")
	private double feelsLikeTemperature;

	@JsonProperty("temp_min")
	private double minimumTemperature;

	@JsonProperty("temp_max")
	private double maximumTemperature;

	@JsonProperty("pressure")
	private int pressure;

	@JsonProperty("sea_level")
	private int seaLevel;

	@JsonProperty("grnd_level")
	private int groundLevel;

	@JsonProperty("humidity")
	private int humidity;

	@JsonProperty("temp_kf")
	private int temperatureKF;

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getFeelsLikeTemperature() {
		return feelsLikeTemperature;
	}

	public void setFeelsLikeTemperature(double feelsLikeTemperature) {
		this.feelsLikeTemperature = feelsLikeTemperature;
	}

	public double getMinimumTemperature() {
		return minimumTemperature;
	}

	public void setMinimumTemperature(double minimumTemperature) {
		this.minimumTemperature = minimumTemperature;
	}

	public double getMaximumTemperature() {
		return maximumTemperature;
	}

	public void setMaximumTemperature(double maximumTemperature) {
		this.maximumTemperature = maximumTemperature;
	}

	public int getPressure() {
		return pressure;
	}

	public void setPressure(int pressure) {
		this.pressure = pressure;
	}

	public int getSeaLevel() {
		return seaLevel;
	}

	public void setSeaLevel(int seaLevel) {
		this.seaLevel = seaLevel;
	}

	public int getGroundLevel() {
		return groundLevel;
	}

	public void setGroundLevel(int groundLevel) {
		this.groundLevel = groundLevel;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public int getTemperatureKF() {
		return temperatureKF;
	}

	public void setTemperatureKF(int temperatureKF) {
		this.temperatureKF = temperatureKF;
	}

	
	
}
