package com.weather.weatherforecast.condition.conditionImpl;

import com.weather.weatherforecast.condition.Condition;
import com.weather.weatherforecast.constant.WeatherForecastConstant;
import com.weather.weatherforecast.model.Forecast;

public class NoWarning implements Condition{

	@Override
	public String checkCondition(Forecast forecast) {
		
		return WeatherForecastConstant.WEATHER_FORECAST_NO_WARNING;
	}

}
