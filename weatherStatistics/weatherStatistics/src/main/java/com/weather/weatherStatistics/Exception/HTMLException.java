package com.weather.weatherStatistics.Exception;

public class HTMLException extends RuntimeException{

    public HTMLException(String message) {
        super(message);
    }

    public HTMLException(String message, Throwable cause) {
        super(message, cause);
    }
}
