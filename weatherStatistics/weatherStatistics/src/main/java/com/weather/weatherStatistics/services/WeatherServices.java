package com.weather.weatherStatistics.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.weatherStatistics.Exception.APINotFoundError;
import com.weather.weatherStatistics.bo.Root;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class WeatherServices {

    @Value("${keyAPI}")
    String keyAPI;
    @Value("${hostAPI}")

    String hostAPI;
    private  Root getWeatherStatisticsFromAPI(String c)  {
        Root weatherObject = null;
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://weatherapi-com.p.rapidapi.com/forecast.json?q=" + c + "&days=10"))
                    .header("X-RapidAPI-Key", keyAPI)
                    .header("X-RapidAPI-Host", hostAPI)
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
           // System.out.println("JSON OBJECT >> " + response.body());
            // Parse the JSON
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(response.body());
            // Check if the "error" field exists in Json
            if (rootNode.has("error") || rootNode.has("message")) {
                // Extract the error code and message
                JsonNode errorNode = rootNode.get("error");
                String errorMessage = errorNode.get("message").asText();

//                JsonNode errorMessage = rootNode.get("message");
//                String message = errorMessage.asText();
                throw new APINotFoundError(errorMessage);
            } else {
                // No error, get the Weather Java Object
                weatherObject = objectMapper.readValue(response.body(), Root.class);
                System.out.println("JAVA OBJECT >> "+ weatherObject.getCurrent().getCondition().getText());
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
