package com.andrea.weather.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.andrea.weather.dto.OpenMeteoResponse;
import com.andrea.weather.dto.OpenMeteoResponse.CurrentWeather;
import com.andrea.weather.entities.City;
import com.andrea.weather.entities.WeatherMeasurement;
import com.andrea.weather.repository.CityRepository;
import com.andrea.weather.repository.WeatherRepository;
import com.andrea.weather.util.WeatherUnitValidator;


@Service
public class WeatherCollectorService {

    private final CityRepository cityRepository;
    private final WeatherRepository weatherRepository;
    private final OpenMeteoService openMeteoService;
    private final WeatherUnitValidator validator;

    public WeatherCollectorService(
            CityRepository cityRepository,
            WeatherRepository weatherRepository,
            OpenMeteoService openMeteoService,
            WeatherUnitValidator validator) {

        this.cityRepository = cityRepository;
        this.weatherRepository = weatherRepository;
        this.openMeteoService = openMeteoService;
        this.validator = validator;
    }


    @Scheduled(fixedRate = 600000)
    public void collectWeatherData() {

        List<City> cities = cityRepository.findAll();

        for (City city : cities) {

            OpenMeteoResponse response = openMeteoService.getCurrentWeather(city);

			if (!validator.validateUnits(response.getCurrentWeatherUnits())) {
				System.err.println("Measurement discarded: invalid weather units for city " + city.getName());
				continue;
			}

            CurrentWeather current = response.getCurrentWeather();

            WeatherMeasurement measurement =
                    new WeatherMeasurement(
                            city,
                            current.getTemperature(),
                            current.getWindSpeed(),
                            current.getWindDirection(),
                            current.getWeatherCode(),
                            LocalDateTime.parse(current.getTime()));

            weatherRepository.save(measurement);
        }
    }
}