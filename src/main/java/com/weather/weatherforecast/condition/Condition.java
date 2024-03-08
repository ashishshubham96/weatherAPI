package com.weather.weatherforecast.condition;

import com.weather.weatherforecast.model.Forecast;

public interface Condition {

	String checkCondition(Forecast forecast);
}
