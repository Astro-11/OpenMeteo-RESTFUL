package com.andrea.weather.service;

import com.andrea.weather.dto.OpenMeteoResponse;
import com.andrea.weather.entities.City;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class OpenMeteoService {

    private final RestClient restClient;

    public OpenMeteoService() {
        this.restClient = RestClient.create();
    }

    public OpenMeteoResponse getCurrentWeather(City city) {
        return restClient
                .get()
                .uri(buildUri(city))
                .retrieve()
                .body(OpenMeteoResponse.class);
    }
    
    private String buildUri(City city) {
        return "https://api.open-meteo.com/v1/forecast"
                + "?latitude=" + city.getLatitude()
                + "&longitude=" + city.getLongitude()
                + "&current_weather=true";
    }
}