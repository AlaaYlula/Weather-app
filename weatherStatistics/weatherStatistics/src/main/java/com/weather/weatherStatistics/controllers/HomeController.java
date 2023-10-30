package com.weather.weatherStatistics.controllers;

import com.weather.weatherStatistics.services.servicesImplemantation.HomeServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HomeController {
    HomeServiceImp htmlService;

    @GetMapping("/")
    public ResponseEntity<String> getHomePage() {
        return htmlService.getHomePage();
    }
}
