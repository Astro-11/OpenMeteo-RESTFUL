package com.andrea.weather.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WeatherConfiguration {

	@Bean
	public WeatherUnitConfig weatherUnitConfig() {
		return new WeatherUnitConfig("iso8601", "°C", "km/h", "°", "wmo code");
	}
}