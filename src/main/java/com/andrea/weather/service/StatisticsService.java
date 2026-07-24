package com.andrea.weather.service;

import com.andrea.weather.dto.WeatherAverageResponse;
import com.andrea.weather.repository.WeatherRepository;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    private final WeatherRepository weatherRepository;

    public StatisticsService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public WeatherAverageResponse getAverage(String cityName) {

		if (!weatherRepository.existsByCityName(cityName)) {
			throw new RuntimeException("No weather data found for city: " + cityName);
		}

		Map<String, Object> result = weatherRepository.findAverageByCityName(cityName);

		return new WeatherAverageResponse(
				cityName, 
				(Double) result.get("temperature"),
				(Double) result.get("windSpeed"), 
				(Double) result.get("windDirection"));
	}
}
