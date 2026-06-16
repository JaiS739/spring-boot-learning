package com.spring_security.security_practice.dto;

import lombok.Data;

@Data
public class RegisterUserDTO {
    private String email;

    private String password;
}
