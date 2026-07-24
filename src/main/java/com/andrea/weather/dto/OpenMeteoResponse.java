package com.andrea.weather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpenMeteoResponse {

	@JsonProperty("current_weather")
	private CurrentWeather currentWeather;
	@JsonProperty("current_weather_units")
	private CurrentWeatherUnits currentWeatherUnits;

	public CurrentWeather getCurrentWeather() {
		return currentWeather;
	}

	public void setCurrentWeather(CurrentWeather currentWeather) {
		this.currentWeather = currentWeather;
	}

	public CurrentWeatherUnits getCurrentWeatherUnits() {
		return currentWeatherUnits;
	}

	public void setCurrentWeatherUnits(CurrentWeatherUnits currentWeatherUnits) {
		this.currentWeatherUnits = currentWeatherUnits;
	}

	public static class CurrentWeather {

		private String time;
		private double temperature;
		@JsonProperty("windspeed")
		private double windSpeed;
		@JsonProperty("winddirection")
		private double windDirection;
		@JsonProperty("weathercode")
		private int weatherCode;

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		public double getTemperature() {
			return temperature;
		}

		public void setTemperature(double temperature) {
			this.temperature = temperature;
		}

		public double getWindSpeed() {
			return windSpeed;
		}

		public void setWindSpeed(double windSpeed) {
			this.windSpeed = windSpeed;
		}

		public double getWindDirection() {
			return windDirection;
		}

		public void setWindDirection(double windDirection) {
			this.windDirection = windDirection;
		}

		public int getWeatherCode() {
			return weatherCode;
		}

		public void setWeatherCode(int weatherCode) {
			this.weatherCode = weatherCode;
		}
	}

	public static class CurrentWeatherUnits {

		private String time;
		private String temperature;
		@JsonProperty("windspeed")
		private String windSpeed;
		@JsonProperty("winddirection")
		private String windDirection;
		@JsonProperty("weathercode")
		private String weatherCode;

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		public String getTemperature() {
			return temperature;
		}

		public void setTemperature(String temperature) {
			this.temperature = temperature;
		}

		public String getWindSpeed() {
			return windSpeed;
		}

		public void setWindSpeed(String windSpeed) {
			this.windSpeed = windSpeed;
		}

		public String getWindDirection() {
			return windDirection;
		}

		public void setWindDirection(String windDirection) {
			this.windDirection = windDirection;
		}

		public String getWeatherCode() {
			return weatherCode;
		}

		public void setWeatherCode(String weatherCode) {
			this.weatherCode = weatherCode;
		}
	}
}