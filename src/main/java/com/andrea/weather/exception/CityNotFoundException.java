package com.andrea.weather.exception;

public class CityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8243200728348697129L;

	public CityNotFoundException(String cityName) {
		super("No weather data found for city: " + cityName);
	}
}
