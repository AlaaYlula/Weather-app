package com.weather.weatherStatistics.controllers;

import com.weather.weatherStatistics.services.HtmlService;
import com.weather.weatherStatistics.services.WeatherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Autowired
    HtmlService htmlService;

    public HomeController(HtmlService htmlService) {
        this.htmlService = htmlService;
    }

    @GetMapping("/")
    public String getHomePage() {
        return htmlService.getHomePage();
    }
}
