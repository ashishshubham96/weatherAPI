package com.weather.weatherforecast.service;

import org.springframework.stereotype.Service;

import com.weather.weatherforecast.model.Response;

@Service
public interface WeatherForecastService {
	
	public Response weatherAPIForecast(String city);
}
