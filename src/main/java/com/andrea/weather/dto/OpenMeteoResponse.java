package com.andrea.weather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpenMeteoResponse {
	
    @JsonProperty("current_weather")
    private CurrentWeather currentWeather;

    public CurrentWeather getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(CurrentWeather currentWeather) {
        this.currentWeather = currentWeather;
    }


    public static class CurrentWeather {

        @JsonProperty("temperature")
        private double temperature;
        @JsonProperty("windspeed")
        private double windSpeed;
        @JsonProperty("winddirection")
        private double windDirection;

        public double getTemperature() {
            return temperature;
        }

        public void setTemperature(double temperature) {
            this.temperature = temperature;
        }

        public double getWindspeed() {
            return windSpeed;
        }

        public void setWindspeed(double windspeed) {
            this.windSpeed = windspeed;
        }

        public double getWinddirection() {
            return windDirection;
        }

        public void setWinddirection(double winddirection) {
            this.windDirection = winddirection;
        }

		public int getWeathercode() {
			// TODO Auto-generated method stub
			return 0;
		}
    }
}