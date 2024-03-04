package com.weather.weatherforecast.service;

import org.springframework.stereotype.Service;

import com.weather.weatherforecast.model.WeatherForecastResponse;

@Service
public interface WeatherForecastService {
	
	public WeatherForecastResponse weatherAPIForecast(String city);
}
