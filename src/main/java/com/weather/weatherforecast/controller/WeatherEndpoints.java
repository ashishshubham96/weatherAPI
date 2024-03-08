package com.weather.weatherforecast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.weatherforecast.constant.WeatherForecastConstant;
import com.weather.weatherforecast.exception.WeatherForecastException;
import com.weather.weatherforecast.model.ErrorInfo;
import com.weather.weatherforecast.model.Response;
import com.weather.weatherforecast.model.WeatherForecastResponse;
import com.weather.weatherforecast.service.WeatherForecastService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class WeatherEndpoints {

	private final HttpServletRequest request;

	private final ObjectMapper mapper;

	@Autowired
	WeatherForecastService weatherForecastService;

	@Autowired
	public WeatherEndpoints(ObjectMapper objectMapper, HttpServletRequest request) {

		this.mapper = new ObjectMapper();
		// this.mapper =
		// objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
		// true);
		this.request = request;
	}

	@ApiOperation(value = "Gets list of overrides", nickname = "getOverrides", notes = "Retrieves list of overrides based on the provided country code and rule key which is service key and account number combination", response = WeatherForecastResponse.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successful response", response = WeatherForecastResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorInfo.class),
			@ApiResponse(code = 401, message = "Unauthorized Access", response = ErrorInfo.class),
			@ApiResponse(code = 403, message = "Forbidden", response = ErrorInfo.class),
			@ApiResponse(code = 404, message = "The server has not found anything matching the URI given", response = ErrorInfo.class) })
	@GetMapping(value = "/weatherforecast/{city}")
	public ResponseEntity<Response> getWeatherForecast(@PathVariable("city") String city) {
		Response response = new Response();
		try {
			if (!city.isBlank()) {
				response = weatherForecastService.weatherAPIForecast(city);
			} else {
				throw new WeatherForecastException(WeatherForecastConstant.CITY_NOT_SPECIFIED);
			}
		} catch (Exception ex) {
			if (response.getErrorInfo() == null) {
				ErrorInfo errorInfo = new ErrorInfo();
				response.setErrorInfo(errorInfo);
			}
			response.getErrorInfo().setErrorMessage(ex.getLocalizedMessage());

		}

		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
}
