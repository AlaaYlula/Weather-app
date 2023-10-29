package com.weather.weatherStatistics.controllers;

import com.weather.weatherStatistics.services.HtmlService;
import com.weather.weatherStatistics.services.WeatherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "weather")
public class WeatherController {

    @Autowired
    WeatherServices weatherServices;

    public WeatherController(WeatherServices weatherServices ) {
        this.weatherServices = weatherServices;
    }

    @GetMapping("/{c}")
    public ResponseEntity<Object> getWeatherStatistics(@PathVariable("c") String c ){
        return weatherServices.getWeather(c );
    }

//    @GetMapping("/{c}/{numberOfDays}")
//    public Root getWeatherStatisticsByNumberOfDays(@PathVariable("c") String c , @PathVariable("numberOfDays") String numberOfDays){
//        return weatherServices.getWeatherByNumberOfDays(c,numberOfDays);
//    }
}
