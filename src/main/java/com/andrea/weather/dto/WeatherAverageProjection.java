package com.andrea.weather.dto;

public record WeatherAverageProjection(
        Double temperature,
        Double windSpeed,
        Double windDirection
) {}
