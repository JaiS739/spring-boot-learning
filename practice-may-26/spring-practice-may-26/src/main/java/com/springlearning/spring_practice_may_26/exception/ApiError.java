package com.springlearning.spring_practice_may_26.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ApiError {
    private String message;

    private HttpStatus httpStatus;
}
