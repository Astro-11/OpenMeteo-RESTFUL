package com.andrea.weather.dto;

public class WeatherUnits {

	private String temperature;
	private String windSpeed;
	private String windDirection;

	public WeatherUnits(String temperature, String windSpeed, String windDirection) {
		this.temperature = temperature;
		this.windSpeed = windSpeed;
		this.windDirection = windDirection;
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
}