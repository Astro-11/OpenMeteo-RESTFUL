package com.andrea.weather.dto;

public class WeatherAverageResponse {

    private String city;
    private double averageTemperature;
    private double averageWindSpeed;
    private double averageWindDirection;
    private Integer prevalentWeatherCode;
    private WeatherUnits units;

    public WeatherAverageResponse(
            String city,
            double averageTemperature,
            double averageWindSpeed,
            double averageWindDirection,
            Integer prevalentWeatherCode,
            WeatherUnits units) {

        this.city = city;
        this.averageTemperature = averageTemperature;
        this.averageWindSpeed = averageWindSpeed;
        this.averageWindDirection = averageWindDirection;
        this.prevalentWeatherCode = prevalentWeatherCode;
        this.units = units;
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

    public Integer getPrevalentWeatherCode() {
        return prevalentWeatherCode;
    }

    public WeatherUnits getUnits() {
        return units;
    }
}