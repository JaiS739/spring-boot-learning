package com.spring_security.security_practice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class APISuccessResponse<T> {
    private String timestamp;
    private int status;
    private boolean success;
    private String message;
    private T data;
}
