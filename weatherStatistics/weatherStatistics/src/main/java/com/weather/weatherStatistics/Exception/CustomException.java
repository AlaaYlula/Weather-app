package com.weather.weatherStatistics.Exception;

import lombok.*;
import org.springframework.http.HttpStatus;


@AllArgsConstructor
@Getter
@Setter
@ToString
public class CustomException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus ;

}
