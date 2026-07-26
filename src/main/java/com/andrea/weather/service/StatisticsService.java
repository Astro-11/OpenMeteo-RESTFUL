package com.andrea.weather.service;

import com.andrea.weather.config.WeatherUnitConfig;
import com.andrea.weather.dto.WeatherAverageProjection;
import com.andrea.weather.dto.WeatherAverageResponse;
import com.andrea.weather.dto.WeatherUnits;
import com.andrea.weather.exception.CityNotFoundException;
import com.andrea.weather.repository.WeatherRepository;

import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

	private final WeatherRepository weatherRepository;
	private final WeatherUnitConfig unitConfig;

	public StatisticsService(WeatherRepository weatherRepository, WeatherUnitConfig unitConfig) {
		this.weatherRepository = weatherRepository;
		this.unitConfig = unitConfig;
	}

	public WeatherAverageResponse getAverage(String cityName) {

		if (!weatherRepository.existsByCityName(cityName)) {
			throw new CityNotFoundException(cityName);
		}
		
		WeatherAverageProjection result = weatherRepository.findAverageByCityName(cityName);
		Integer prevalentWeatherCode = weatherRepository.findPrevalentWeatherCode(cityName);

		WeatherUnits units = new WeatherUnits(
				unitConfig.temperature(), 
				unitConfig.windSpeed(),
				unitConfig.windDirection(), 
				unitConfig.weatherCode());

		return new WeatherAverageResponse(cityName,
				result.temperature(), 
				result.windSpeed(), 
				result.windDirection(),
				prevalentWeatherCode, units);
	}
}