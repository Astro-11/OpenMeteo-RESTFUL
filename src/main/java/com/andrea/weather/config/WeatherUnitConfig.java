package com.andrea.weather.config;

public record WeatherUnitConfig(
		String time, 
		String temperature, 
		String windSpeed, 
		String windDirection,
		String weatherCode) {
}
