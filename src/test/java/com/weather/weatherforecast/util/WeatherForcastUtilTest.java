package com.weather.weatherforecast.util;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import com.weather.weatherforecast.model.Forecast;
import com.weather.weatherforecast.model.Main;
import com.weather.weatherforecast.model.Weather;
import com.weather.weatherforecast.model.WeatherForecastResponse;
import com.weather.weatherforecast.model.Winds;
import com.weather.weatherforecast.service.serviceImpl.WeatherForecastServiceImpl;

public class WeatherForcastUtilTest {

	@InjectMocks
	WeatherForcastUtil weatherForcastUtil;

	WeatherForecastResponse weatherForecastResponse;
	
    @BeforeEach
    public void setUp() {
    	weatherForcastUtil = new WeatherForcastUtil();
    	weatherForecastResponse = new WeatherForecastResponse();
    	Forecast forecast = new Forecast();
    	Main main = new Main();
    	main.setMaximumTemperature(300);
    	Winds wind = new Winds();
    	wind.setSpeed(15);
    	Weather weather = new Weather();
    	weather.setId(210);
    	List<Weather> weatherList = new ArrayList<>();
    	weatherList.add(weather);
    	forecast.setMain(main);
    	forecast.setWeathers(weatherList);
    	forecast.setWinds(wind);
    	List<Forecast> forecastList = new ArrayList<>();
    	forecastList.add(forecast);
    	weatherForecastResponse.setForecasts(forecastList);
    }
    
    @Test
    void processForecastResponse() {
    	weatherForecastResponse = weatherForcastUtil.processForecastResponse(weatherForecastResponse);
    	assertNotNull(weatherForecastResponse);
    }
    
    @Test
    void processForecastResponse2() {
    	weatherForecastResponse.getForecasts().get(0).getWeathers().get(0).setId(510);;
    	weatherForecastResponse = weatherForcastUtil.processForecastResponse(weatherForecastResponse);
    	assertNotNull(weatherForecastResponse);
    }
}
