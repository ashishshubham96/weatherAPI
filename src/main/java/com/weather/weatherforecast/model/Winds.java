package com.weather.weatherforecast.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Winds {
	
	@JsonProperty("speed")
	private double speed;

	@JsonProperty("deg")
	private int degree;

	@JsonProperty("gust")
	private double gust;

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public double getGust() {
		return gust;
	}

	public void setGust(double gust) {
		this.gust = gust;
	}

}
