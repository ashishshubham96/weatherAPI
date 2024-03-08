package com.weather.weatherforecast.condition.conditionImpl;

import com.weather.weatherforecast.condition.Condition;
import com.weather.weatherforecast.constant.WeatherForecastConstant;
import com.weather.weatherforecast.model.Forecast;

public class TemperatureWarning implements Condition{

	@Override
	public String checkCondition(Forecast forecast) {
		String forecastSummary = new String();
		if (kelvinToCelsius(forecast.getMain().getMaximumTemperature()) > 40.00) {
			forecastSummary = WeatherForecastConstant.WEATHER_FORECAST_TEMPERATURE_WARNING;
		}
		return forecastSummary;
	}

	private static double kelvinToCelsius(double kelvinTemp) {
		double celsiusTemp = 0.0;
		celsiusTemp = kelvinTemp - 273.15;
		return celsiusTemp;
	}

	
}
