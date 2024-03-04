package com.weather.weatherforecast.service.serviceImpl;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import com.weather.weatherforecast.model.WeatherForecastResponse;
import com.weather.weatherforecast.service.WeatherForecastService;
import com.weather.weatherforecast.util.WeatherForcastUtil;

@Service
public class WeatherForecastServiceImpl implements WeatherForecastService{

	@Value("${weather-api.api.forecast.url}")
	private String weatherForecastApiUrl;

	@Value("${weather-api.api.key}")
	private String apiKey;

	@Value("${weather-api.api.forecast.numberofdays}")
	private String numberOfDays;
	
	@Autowired
	private WeatherForcastUtil weatherForecastUtil;

	private RestTemplate weatherRestTemplate;
	
	public WeatherForecastServiceImpl(RestTemplateBuilder restTemplateBuilder) {
		weatherRestTemplate = restTemplateBuilder.build();
	  }
	
	@Override
	@Cacheable("city")
	public WeatherForecastResponse weatherAPIForecast(String city) {
		// TODO Auto-generated method stub
		WeatherForecastResponse weatherForecastResponse = new WeatherForecastResponse();
		try {
			URI weatherApiUrl = new UriTemplate(weatherForecastApiUrl).expand(city, apiKey, numberOfDays);
			ResponseEntity<WeatherForecastResponse> response = weatherRestTemplate.getForEntity(weatherApiUrl, WeatherForecastResponse.class);
			weatherForecastResponse = weatherForecastUtil.processForecastResponse(response.getBody());

		}catch(Exception ex) {
			weatherForecastResponse.setMessage(ex.getLocalizedMessage());
		}
		return weatherForecastResponse;
	}
	
}