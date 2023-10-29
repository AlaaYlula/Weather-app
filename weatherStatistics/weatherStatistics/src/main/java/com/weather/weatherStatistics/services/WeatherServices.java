package com.weather.weatherStatistics.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.weatherStatistics.Exception.APINotFoundError;
import com.weather.weatherStatistics.bo.Root;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherServices {

    @Value("${keyAPI}")
    String keyAPI;
    @Value("${hostAPI}")
    String hostAPI;
    @Value("${api}")
    String apiLink;

    // Function to hit the API and return the weather Object.
    private  Root getWeatherStatisticsFromAPI(String c) throws UnsupportedEncodingException {
        Root weatherObject = null;
        String cityCountryName = c.replace(" ","%20");
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiLink+"?q=" + cityCountryName + "&days=10"))
                    .header("X-RapidAPI-Key", keyAPI)
                    .header("X-RapidAPI-Host", hostAPI)
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            // Parse the JSON
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(response.body());
            // Check if the "error" field exists in Json
            if (rootNode.has("error") || rootNode.has("message")) {
                // Extract the error code and message
                JsonNode errorNode = rootNode.get("error");
                String errorMessage = errorNode.get("message").asText();
                throw new APINotFoundError(errorMessage);
            } else {
                // No error, get the Weather Java Object
                weatherObject = objectMapper.readValue(response.body(), Root.class);
            }

        }catch (Exception e){
            //API Error
            throw new APINotFoundError(e.getMessage(),e.getCause());
        }
        return weatherObject;
    }

    public ResponseEntity<Object> getWeather(String c) {
        Root weatherCity = null;
        try {
            weatherCity = getWeatherStatisticsFromAPI(c);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new APINotFoundError(exception.getMessage(),exception.getCause() ));
        }
        return ResponseEntity.ok(weatherCity);

    }


//    public Root getWeatherByNumberOfDays(String c, String numberOfDays) {
//        Root weatherCity;
//        try {
//            weatherCity = getWeatherStatisticsFromAPI(c,Integer.parseInt(numberOfDays));
//        }catch (Exception exception){
//            throw new APINotFoundError(exception.getMessage() , exception.getCause());
//        }
//        return weatherCity;
//    }
}
