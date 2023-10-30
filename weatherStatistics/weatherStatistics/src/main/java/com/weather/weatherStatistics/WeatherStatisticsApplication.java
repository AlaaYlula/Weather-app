package com.weather.weatherStatistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WeatherStatisticsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherStatisticsApplication.class, args);

	}


	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
