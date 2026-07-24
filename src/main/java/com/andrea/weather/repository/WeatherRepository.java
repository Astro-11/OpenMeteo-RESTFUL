package com.andrea.weather.repository;

import com.andrea.weather.entities.WeatherMeasurement;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WeatherRepository extends JpaRepository<WeatherMeasurement, Long> {
	@Query("""
		       SELECT new map(
		           AVG(w.temperature) as temperature,
		           AVG(w.windSpeed) as windSpeed,
		           AVG(w.windDirection) as windDirection
		       )
		       FROM WeatherMeasurement w
		       WHERE w.city.name = :cityName
		       """)
		Map<String, Object> findAverageByCityName(@Param("cityName") String cityName);
	
	boolean existsByCityName(String cityName);
}
