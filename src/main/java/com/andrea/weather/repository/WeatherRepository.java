package com.andrea.weather.repository;

import com.andrea.weather.dto.WeatherAverageProjection;
import com.andrea.weather.entities.WeatherMeasurement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WeatherRepository extends JpaRepository<WeatherMeasurement, Long> {

	@Query("""
	       SELECT new com.andrea.weather.dto.WeatherAverageProjection(
	           AVG(w.temperature),
	           AVG(w.windSpeed),
	           AVG(w.windDirection))
	       FROM WeatherMeasurement w
	       WHERE w.city.name = :cityName
	       """)
	WeatherAverageProjection findAverageByCityName(@Param("cityName") String cityName);

    @Query("""
           SELECT w.weatherCode
           FROM WeatherMeasurement w
           WHERE w.city.name = :cityName
           GROUP BY w.weatherCode
           ORDER BY COUNT(w.weatherCode) DESC
           LIMIT 1
           """)
    Integer findPrevalentWeatherCode(@Param("cityName") String cityName);

    boolean existsByCityName(String cityName);
}