package com.weather.weatherStatistics;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.weatherStatistics.bo.Root;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
public class WeatherStatisticsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherStatisticsApplication.class, args);

	}



}
