package com.weather.weatherforecast.condition.conditionImpl;

import com.weather.weatherforecast.condition.Condition;
import com.weather.weatherforecast.constant.WeatherForecastConstant;
import com.weather.weatherforecast.model.Forecast;

public class WindWarning implements Condition {

	private static WindWarning windWarningObj;

	public static WindWarning getWindWarning() {
		if (windWarningObj == null) {
			windWarningObj = new WindWarning();
		}
		return windWarningObj;
	}

	@Override
	public String checkCondition(Forecast forecast) {
		String forecastSummary = new String();
		if (forecast.getWinds().getSpeed() > 10.00) {
			forecastSummary = WeatherForecastConstant.WEATHER_FORECAST_WIND_WARNING;
		}
		return forecastSummary;
	}

}
