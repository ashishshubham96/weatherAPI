package com.weather.weatherforecast.condition.conditionImpl;

import com.weather.weatherforecast.condition.Condition;
import com.weather.weatherforecast.constant.WeatherForecastConstant;

public class ConditionFactory {
	
	public static Condition getCondition(String condition) {
		
		if(condition.trim().equals(WeatherForecastConstant.TEMPERATURE)) {
			return TemperatureWarning.getTemperatureWarning();
		}
		else if(condition.trim().equals(WeatherForecastConstant.RAIN)) {
			return RainWarning.getRainWarning();
		}
		else if(condition.trim().equals(WeatherForecastConstant.WIND)) {
			return WindWarning.getWindWarning();
		}
		else if(condition.trim().equals(WeatherForecastConstant.THUNDERSTORM)) {
			return ThunderstormWarning.getThunderstormWarning();
		}
		
		return NoWarning.getNoWarning();
	}
}
