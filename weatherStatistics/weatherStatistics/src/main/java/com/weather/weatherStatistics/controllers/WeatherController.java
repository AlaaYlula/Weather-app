package com.weather.weatherStatistics.controllers;

import com.weather.weatherStatistics.services.WeatherServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "weather")
@AllArgsConstructor
public class WeatherController {

    WeatherServices weatherServices;

    @GetMapping("/{c}")
    public ResponseEntity<Object> getWeatherStatistics(@PathVariable("c") String c ){
        return weatherServices.getWeather(c );
    }

//    @GetMapping("/{c}/{numberOfDays}")
//    public Root getWeatherStatisticsByNumberOfDays(@PathVariable("c") String c , @PathVariable("numberOfDays") String numberOfDays){
//        return weatherServices.getWeatherByNumberOfDays(c,numberOfDays);
//    }
}
