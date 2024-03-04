package com.weather.weatherforecast.exception;

import java.util.Objects;

public class WeatherForecastException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private final String errorMessage;

	public WeatherForecastException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "WeatherForecastException [errorMessage=" + errorMessage + "]";
	}

	

}
