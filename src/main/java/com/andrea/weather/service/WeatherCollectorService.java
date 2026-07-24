package com.andrea.weather.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.andrea.weather.dto.OpenMeteoResponse;
import com.andrea.weather.entities.City;
import com.andrea.weather.entities.WeatherMeasurement;
import com.andrea.weather.repository.CityRepository;
import com.andrea.weather.repository.WeatherRepository;

@Service
public class WeatherCollectorService {

    private final CityRepository cityRepository;
    private final WeatherRepository weatherRepository;
    private final OpenMeteoService openMeteoService;

    public WeatherCollectorService(
            CityRepository cityRepository,
            WeatherRepository weatherRepository,
            OpenMeteoService openMeteoService) {

        this.cityRepository = cityRepository;
        this.weatherRepository = weatherRepository;
        this.openMeteoService = openMeteoService;
    }
    
    @Scheduled(fixedRate = 600000)
    public void collectWeatherData() {

        List<City> cities = cityRepository.findAll();

        for (City city : cities) {

			OpenMeteoResponse response = openMeteoService.getCurrentWeather(city);

            WeatherMeasurement measurement = new WeatherMeasurement(
                            city,
                            response.getCurrentWeather().getTemperature(),
                            response.getCurrentWeather().getWindspeed(),
                            response.getCurrentWeather().getWinddirection(),
                            response.getCurrentWeather().getWeathercode(),
                            LocalDateTime.now());

            weatherRepository.save(measurement);
        }
    }

}