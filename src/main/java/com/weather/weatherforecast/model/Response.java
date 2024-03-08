package com.weather.weatherforecast.model;

public class Response {

	WeatherForecastResponse WeatherForecastResponse;
	
	ErrorInfo errorInfo;

	public WeatherForecastResponse getWeatherForecastResponse() {
		return WeatherForecastResponse;
	}

	public void setWeatherForecastResponse(WeatherForecastResponse weatherForecastResponse) {
		WeatherForecastResponse = weatherForecastResponse;
	}

	public ErrorInfo getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}
	
	
}
