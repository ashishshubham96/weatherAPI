package com.weather.weatherforecast.condition.conditionImpl;

import com.weather.weatherforecast.condition.Condition;
import com.weather.weatherforecast.constant.WeatherForecastConstant;
import com.weather.weatherforecast.model.Forecast;

public class NoWarning implements Condition {

	private static NoWarning noWarningObj;

	public static NoWarning getNoWarning() {
		if (noWarningObj == null) {
			noWarningObj = new NoWarning();
		}
		return noWarningObj;
	}

	@Override
	public String checkCondition(Forecast forecast) {

		return WeatherForecastConstant.WEATHER_FORECAST_NO_WARNING;
	}

}
