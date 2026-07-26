package com.andrea.weather.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "city_id", "timestamp" }) })
public class WeatherMeasurement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "city_id", nullable = false)
	private City city;

	private double temperature;
	private double windSpeed;
	private double windDirection;
	private int weatherCode;
	private LocalDateTime timestamp;

	protected WeatherMeasurement() {
	}

	public WeatherMeasurement(City city,
			double temperature, 
			double windSpeed, 
			double windDirection, 
			int weatherCode,
			LocalDateTime timestamp) {

		this.city = city;
		this.temperature = temperature;
		this.windSpeed = windSpeed;
		this.windDirection = windDirection;
		this.weatherCode = weatherCode;
		this.timestamp = timestamp;
	}

	public Long getId() {
		return id;
	}

	public City getCity() {
		return city;
	}

	public double getTemperature() {
		return temperature;
	}

	public double getWindSpeed() {
		return windSpeed;
	}

	public double getWindDirection() {
		return windDirection;
	}

	public int getWeatherCode() {
		return weatherCode;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}
}