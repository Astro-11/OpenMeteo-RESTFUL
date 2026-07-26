package com.andrea.weather.controller;

import com.andrea.weather.dto.WeatherAverageResponse;
import com.andrea.weather.entities.City;
import com.andrea.weather.repository.CityRepository;
import com.andrea.weather.service.StatisticsService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/weather")
public class WeatherController {

	private final StatisticsService statisticsService;
	private final CityRepository cityRepository;

	public WeatherController(StatisticsService statisticsService, CityRepository cityRepository) {

		this.statisticsService = statisticsService;
		this.cityRepository = cityRepository;
	}

	@GetMapping("/averages")
	public List<WeatherAverageResponse> getAllAverages() {

		return cityRepository.findAll()
				.stream().map(city -> statisticsService.getAverage(city.getName())).toList();
	}

	@GetMapping("/averages/{city}")
	public WeatherAverageResponse getAverage(@PathVariable String city) {
		try {
			return statisticsService.getAverage(city);
		} catch (RuntimeException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@GetMapping("/cities")
	public List<City> getCities() {
		return cityRepository.findAll();
	}
}