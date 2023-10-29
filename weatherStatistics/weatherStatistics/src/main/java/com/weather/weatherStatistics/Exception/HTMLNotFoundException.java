package com.weather.weatherStatistics.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;


public class HTMLNotFoundException extends RuntimeException {
    public HTMLNotFoundException(String message) {
        super(message);
    }

    public HTMLNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
