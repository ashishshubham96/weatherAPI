package com.weather.weatherforecast.condition.conditionImpl;

import com.weather.weatherforecast.condition.Condition;
import com.weather.weatherforecast.constant.WeatherForecastConstant;

public class ConditionFactory {
	
	public static Condition getCondition(String condition) {
		
		if(condition.trim().equals(WeatherForecastConstant.TEMPERATURE)) {
			return new TemperatureWarning();
		}
		else if(condition.trim().equals(WeatherForecastConstant.RAIN)) {
			return new RainWarning();
		}
		else if(condition.trim().equals(WeatherForecastConstant.WIND)) {
			return new WindWarning();
		}
		else if(condition.trim().equals(WeatherForecastConstant.THUNDERSTORM)) {
			return new ThunderstormWarning();
		}
		
		return new NoWarning();
	}
}
