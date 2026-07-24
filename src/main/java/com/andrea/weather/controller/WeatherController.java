package com.andrea.weather.controller;

import com.andrea.weather.dto.WeatherAverageResponse;
import com.andrea.weather.entities.City;
import com.andrea.weather.repository.CityRepository;
import com.andrea.weather.service.StatisticsService;

import java.util.List;

import org.springframework.web.bind.annotation.*;

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

		return cityRepository.findAll().stream()
				.map(city -> statisticsService.getAverage(city.getName())).toList();
	}

    @GetMapping("/averages/{city}")
	public WeatherAverageResponse getAverage(@PathVariable String city) {
		return statisticsService.getAverage(city);
    }

    @GetMapping("/cities")
    public List<City> getCities() {
        return cityRepository.findAll();
    }
}