package com.weather.weatherStatistics.services;

import org.springframework.http.ResponseEntity;

public interface WeatherService {
     ResponseEntity<Object> getWeather(String c);
}
