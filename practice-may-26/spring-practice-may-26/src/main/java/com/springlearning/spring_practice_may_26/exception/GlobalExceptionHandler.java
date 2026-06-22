package com.springlearning.spring_practice_may_26.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//Global exception does two things:
//
//Catches exceptions from anywhere in the application.
//Converts them into proper HTTP responses (404, 400, 401, 500, etc.).


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFoundException(ResourceNotFoundException e) {

        ApiError apiError = new ApiError(
                e.getMessage(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND); //here it is using ResponseEntityConstrucoty
//        you can also write it like -
//        return ResponseEntity // this is more common
//                .status(HttpStatus.NOT_FOUND)
//                .body(apiError);
    }


    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ApiError> handleAuthenticationException(AuthenticationException e) {
        ApiError apiError = new ApiError(e.getMessage(), HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(apiError, HttpStatus.UNAUTHORIZED);
    }
}
