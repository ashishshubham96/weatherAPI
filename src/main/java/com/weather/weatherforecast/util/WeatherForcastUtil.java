package com.weather.weatherforecast.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.weather.weatherforecast.condition.Condition;
import com.weather.weatherforecast.condition.conditionImpl.ConditionFactory;
import com.weather.weatherforecast.constant.WeatherForecastConstant;
import com.weather.weatherforecast.model.Forecast;
import com.weather.weatherforecast.model.WeatherForecastResponse;

@Component
public class WeatherForcastUtil {

	public WeatherForecastResponse processForecastResponse(WeatherForecastResponse forecastResponse) {
		
		List<Forecast> forecasts = forecastResponse.getForecasts();
		Condition temperature = ConditionFactory.getCondition(WeatherForecastConstant.TEMPERATURE);
		Condition rain = ConditionFactory.getCondition(WeatherForecastConstant.RAIN);
		Condition wind = ConditionFactory.getCondition(WeatherForecastConstant.WIND);
		Condition thunderstorm = ConditionFactory.getCondition(WeatherForecastConstant.THUNDERSTORM);

		if (!forecasts.isEmpty()) {
			for (Forecast forecast : forecasts) {
				StringBuilder forecastSummary = new StringBuilder();
								
				forecastSummary.append(temperature.checkCondition(forecast));
				forecastSummary.append(rain.checkCondition(forecast));
				forecastSummary.append(wind.checkCondition(forecast));
				forecastSummary.append(thunderstorm.checkCondition(forecast));
				
				if(forecastSummary.length() == 0) {
					Condition noWarning = ConditionFactory.getCondition("");
					
					forecastSummary.append(noWarning.checkCondition(forecast));
				}
				
				forecast.setForecastSummary(forecastSummary.toString());
			}
		}

		return forecastResponse;
	}
	

}
