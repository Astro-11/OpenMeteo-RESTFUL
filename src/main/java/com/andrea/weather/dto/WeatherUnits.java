package com.andrea.weather.dto;

public class WeatherUnits {

	private String temperature;
	private String windSpeed;
	private String windDirection;
	private String weatherCode;

	public WeatherUnits(String temperature, String windSpeed, String windDirection, String weatherCode) {
		this.temperature = temperature;
		this.windSpeed = windSpeed;
		this.windDirection = windDirection;
		this.weatherCode = weatherCode;
	}

	public String getTemperature() {
		return temperature;
	}

	public String getWindSpeed() {
		return windSpeed;
	}

	public String getWindDirection() {
		return windDirection;
	}

	public String getWeatherCode() {
		return weatherCode;
	}
}