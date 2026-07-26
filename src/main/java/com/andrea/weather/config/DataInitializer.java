package com.andrea.weather.config;

import com.andrea.weather.entities.City;
import com.andrea.weather.repository.CityRepository;
import com.andrea.weather.service.WeatherCollectorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

	private final CityRepository cityRepository;
	private final WeatherCollectorService weatherCollectorService;

	public DataInitializer(CityRepository cityRepository, WeatherCollectorService weatherCollectorService) {
		this.cityRepository = cityRepository;
		this.weatherCollectorService = weatherCollectorService;
	}

	@Override
	public void run(String... args) {
		if (cityRepository.count() == 0) {
			cityRepository.save(new City("Florence", 43.7696, 11.2558));
			cityRepository.save(new City("Rome", 41.9028, 12.4964));
			cityRepository.save(new City("Milan", 45.4642, 9.1900));
			cityRepository.save(new City("Naples", 40.8518, 14.2681));
			cityRepository.save(new City("Turin", 45.0703, 7.6869));
		}

		weatherCollectorService.collectWeatherData();
	}
}
