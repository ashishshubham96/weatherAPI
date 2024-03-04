package com.weather.weatherforecast.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.weather.weatherforecast.constant.WeatherForecastConstant;
import com.weather.weatherforecast.model.Forecast;
import com.weather.weatherforecast.model.WeatherForecastResponse;

@Component
public class WeatherForcastUtil {

	public WeatherForecastResponse processForecastResponse(WeatherForecastResponse forecastResponse) {

		long weatherId = 0;
		List<Forecast> forecasts = forecastResponse.getForecasts();

		if (!forecasts.isEmpty()) {
			for (Forecast forecast : forecasts) {
				StringBuilder forecastSummary = new StringBuilder();
				if (forecast.getWinds().getSpeed() > 10.00) {
					forecastSummary.append(WeatherForecastConstant.WEATHER_FORECAST_WIND_WARNING);
				}
				if (kelvinToCelsius(forecast.getMain().getMaximumTemperature()) > 40.00) {
					forecastSummary.append(WeatherForecastConstant.WEATHER_FORECAST_TEMPERATURE_WARNING);
				}
				
				weatherId = forecast.getWeathers().get(0).getId();
				if (weatherId >= 200 && weatherId <= 233) {
					forecastSummary.append(WeatherForecastConstant.WEATHER_FORECAST_THUNDERSTROM_WARNING);
				}
				if (weatherId >= 500 && weatherId <= 532) {
					forecastSummary.append(WeatherForecastConstant.WEATHER_FORECAST_RAIN_WARNING);
				}
				forecast.setForecastSummary(forecastSummary.toString());
			}
		}

		return forecastResponse;
	}

	private static double kelvinToCelsius(double kelvinTemp) {
		double celsiusTemp = 0.0;
		celsiusTemp = kelvinTemp - 273.15;
		return celsiusTemp;
	}

}
