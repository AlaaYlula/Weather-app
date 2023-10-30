package com.weather.weatherStatistics.services.servicesImplemantation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.weatherStatistics.Exception.CustomNotFoundException;
import com.weather.weatherStatistics.bo.ExceptionAPI.ErrorResponse;
import com.weather.weatherStatistics.bo.weather.RootResponse;
import com.weather.weatherStatistics.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


import org.springframework.http.HttpHeaders;


@Service
public class WeatherServicesImp implements WeatherService {

    @Value("${keyAPI}")
    String keyAPI;
    @Value("${hostAPI}")
    String hostAPI;
    @Value("${api}")
    String apiLink;

    RestTemplate restTemplate;

    public WeatherServicesImp(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public  ResponseEntity<RootResponse> getWeatherStatisticsFromAPI(String c) throws JsonProcessingException {
        String cityCountryName = c.replace(" ","%20");
        RootResponse weatherObject = null;
        try{
            HttpHeaders headers = new HttpHeaders();
            headers.set("X-RapidAPI-Key",keyAPI);
            headers.set("X-RapidAPI-Host",hostAPI);

            ResponseEntity<RootResponse> response = restTemplate.exchange(apiLink+"?q=" + cityCountryName + "&days=10", HttpMethod.GET,new HttpEntity<>(headers), RootResponse.class);
            weatherObject = response.getBody();

        }catch (HttpClientErrorException ex) {
            // Handle the 4xx error here
            String errorResponse =  ex.getResponseBodyAsString();

            ObjectMapper objectMapper = new ObjectMapper();
            ErrorResponse errorObject = objectMapper.readValue(errorResponse, ErrorResponse.class);

            throw new CustomNotFoundException(errorObject.getError().getMessage());
        }catch (Exception e){
            throw new CustomNotFoundException(e.getMessage(),e.getCause());
        }
        return  ResponseEntity.ok(weatherObject);
    }


  @Override
    public ResponseEntity<Object> getWeather(String c) {
        ResponseEntity<RootResponse> weatherCity = null;
        try {
            weatherCity = getWeatherStatisticsFromAPI(c);
        }catch (Exception exception){
            throw new CustomNotFoundException(exception.getMessage());
        }
        return ResponseEntity.ok(weatherCity);

    }



}
