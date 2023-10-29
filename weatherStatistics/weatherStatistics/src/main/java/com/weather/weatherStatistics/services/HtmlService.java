package com.weather.weatherStatistics.services;

import com.weather.weatherStatistics.Exception.HTMLNotFoundException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Service
public class HtmlService {


    public ResponseEntity<String> getHomePage() {

        try{
            // Load the HTML file as a Resource
            Resource resource = new ClassPathResource("templates/home.html");
            InputStream inputStream = resource.getInputStream();

            // Read the html file content to byte array then into a string
            byte[] bytes = FileCopyUtils.copyToByteArray(inputStream);
            String htmlContent = new String(bytes, StandardCharsets.UTF_8);

            //return to display html page on the home.html
            return ResponseEntity.ok(htmlContent);
        }catch (IOException exception){
            System.out.println("In Exception");

            throw new HTMLNotFoundException(exception.getMessage(),exception.getCause());
        }
    }
}
