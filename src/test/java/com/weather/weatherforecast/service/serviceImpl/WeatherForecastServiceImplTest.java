package com.weather.weatherforecast.service.serviceImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.net.URI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.weather.weatherforecast.model.Response;
import com.weather.weatherforecast.model.WeatherForecastResponse;
import com.weather.weatherforecast.util.WeatherForcastUtil;

public class WeatherForecastServiceImplTest {

	@InjectMocks
    private WeatherForecastServiceImpl weatherForecastService;
    @Mock
    private RestTemplate restTemplate;
    @Mock
    private WeatherForcastUtil weatherForcastUtil;

    @BeforeEach
    public void setup() {
        restTemplate = mock(RestTemplate.class);
        RestTemplateBuilder restTemplateBuilder = mock(RestTemplateBuilder.class);
        when(restTemplateBuilder.build()).thenReturn(restTemplate);
        
        weatherForcastUtil = mock(WeatherForcastUtil.class);
        weatherForecastService = new WeatherForecastServiceImpl(restTemplateBuilder);
    }

    @Test
    public void testWeatherAPIForecast_Success() {
        // Mock response entity
        WeatherForecastResponse mockWeatherResponse = new WeatherForecastResponse();
        ResponseEntity<WeatherForecastResponse> mockResponseEntity = new ResponseEntity<>(mockWeatherResponse, HttpStatus.OK);
        when(restTemplate.getForEntity(any(URI.class), eq(WeatherForecastResponse.class)))
                .thenReturn(mockResponseEntity);

        // Mock WeatherForcastUtil
        when(weatherForcastUtil.processForecastResponse(Mockito.any(WeatherForecastResponse.class)))
                .thenReturn(mockWeatherResponse);

        Response response = weatherForecastService.weatherAPIForecast("Delhi");

        assertNotNull(response);
    }

    // Add more test cases to cover failure scenarios
}