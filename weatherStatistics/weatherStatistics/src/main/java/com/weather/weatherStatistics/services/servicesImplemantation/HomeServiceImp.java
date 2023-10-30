package com.weather.weatherStatistics.services.servicesImplemantation;

import com.weather.weatherStatistics.Exception.HTMLNotFoundException;
import com.weather.weatherStatistics.services.HomeService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Service
public class HomeServiceImp implements HomeService {

    @Override
    public ResponseEntity<String> getHomePage() {

        try{
            // Load the HTML file as a Resource
            Resource resource = new ClassPathResource("templates/home.html");
            InputStream inputStream = resource.getInputStream();

            // Read the html file content to byte array then into a string
            byte[] bytes = FileCopyUtils.copyToByteArray(inputStream);
            String htmlContent = new String(bytes, StandardCharsets.UTF_8);

            //return to display the Home html page content on the index.html page
            return ResponseEntity.ok(htmlContent);
        }catch (IOException exception){
            throw new HTMLNotFoundException(exception.getMessage(),exception.getCause());
        }
    }

}
