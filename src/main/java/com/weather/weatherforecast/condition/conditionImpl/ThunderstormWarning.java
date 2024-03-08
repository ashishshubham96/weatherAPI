package com.weather.weatherforecast.condition.conditionImpl;

import com.weather.weatherforecast.condition.Condition;
import com.weather.weatherforecast.constant.WeatherForecastConstant;
import com.weather.weatherforecast.model.Forecast;

public class ThunderstormWarning implements Condition{

	@Override
	public String checkCondition(Forecast forecast) {
		long weatherId = forecast.getWeathers().get(0).getId();
		String forecastSummary = new String();
		if (weatherId >= 200 && weatherId <= 233) {
			forecastSummary = WeatherForecastConstant.WEATHER_FORECAST_RAIN_WARNING;
		}
		return forecastSummary;
	}

}
