package com.andrea.weather.dto;

public class WeatherAverageResponse {

    private String city;
    private double averageTemperature;
    private double averageWindSpeed;
    private double averageWindDirection;

    public WeatherAverageResponse(
            String city,
            double averageTemperature,
            double averageWindSpeed,
            double averageWindDirection) {

        this.city = city;
        this.averageTemperature = averageTemperature;
        this.averageWindSpeed = averageWindSpeed;
        this.averageWindDirection = averageWindDirection;
    }

    public String getCity() {
        return city;
    }

    public double getAverageTemperature() {
        return averageTemperature;
    }

    public double getAverageWindSpeed() {
        return averageWindSpeed;
    }

    public double getAverageWindDirection() {
        return averageWindDirection;
    }
}