package com.weather.weatherStatistics.Exception;

public class HTMLNotFoundException extends RuntimeException {
    public HTMLNotFoundException(String message) {
        super(message);
    }

    public HTMLNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
