package com.weather.weatherStatistics.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class CustomExceptionHandler {

    // Handle CustomNotFoundException exceptions
    @ExceptionHandler(value = {CustomNotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(CustomNotFoundException notFoundError){
            CustomException customException = new CustomException(notFoundError.getMessage(), notFoundError.getCause() , HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(customException , HttpStatus.NOT_FOUND);
    }


}
