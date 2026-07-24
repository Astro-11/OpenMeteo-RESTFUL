package com.andrea.weather.util;

import org.springframework.stereotype.Component;

import com.andrea.weather.config.WeatherUnitConfig;
import com.andrea.weather.dto.OpenMeteoResponse;

@Component
public class WeatherUnitValidator {

    private final WeatherUnitConfig expectedUnits;

    public WeatherUnitValidator(WeatherUnitConfig expectedUnits) {
        this.expectedUnits = expectedUnits;
    }

    public boolean validateUnits(OpenMeteoResponse.CurrentWeatherUnits units) {
        return expectedUnits.time().equals(units.getTime())
                && expectedUnits.temperature().equals(units.getTemperature())
                && expectedUnits.windSpeed().equals(units.getWindSpeed())
                && expectedUnits.windDirection().equals(units.getWindDirection())
                && expectedUnits.weatherCode().equals(units.getWeatherCode());
    }
}