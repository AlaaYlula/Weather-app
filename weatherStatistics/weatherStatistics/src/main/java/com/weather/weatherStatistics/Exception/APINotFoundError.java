package com.weather.weatherStatistics.Exception;

public class APINotFoundError extends RuntimeException{

    public APINotFoundError(String message) {
        super(message);
    }

    public APINotFoundError(String message, Throwable cause) {
        super(message, cause);
    }
}
