package com.weather.weatherStatistics.controllers;

import com.weather.weatherStatistics.services.HtmlService;
import com.weather.weatherStatistics.services.WeatherServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HomeController {
    HtmlService htmlService;

    @GetMapping("/")
    public ResponseEntity<String> getHomePage() {
        return htmlService.getHomePage();
    }
}
