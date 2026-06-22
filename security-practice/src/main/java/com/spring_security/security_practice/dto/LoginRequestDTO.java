package com.spring_security.security_practice.dto;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String email;

    private String password;
}
