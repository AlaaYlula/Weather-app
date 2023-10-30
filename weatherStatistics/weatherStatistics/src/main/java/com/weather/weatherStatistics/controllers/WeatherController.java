package com.weather.weatherStatistics.controllers;

import com.weather.weatherStatistics.services.servicesImplemantation.WeatherServicesImp;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "weather")
@AllArgsConstructor
public class WeatherController {

    WeatherServicesImp weatherServices;

    @GetMapping("/{c}")
    public ResponseEntity<Object> getWeatherStatistics(@PathVariable("c") String c ){
        return weatherServices.getWeather(c );
    }

}
