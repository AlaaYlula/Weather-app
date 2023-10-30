package com.weather.weatherStatistics.services;

import org.springframework.http.ResponseEntity;

public interface HomeService {
     ResponseEntity<String> getHomePage();
}
