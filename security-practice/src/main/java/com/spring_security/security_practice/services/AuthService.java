package com.spring_security.security_practice.services;

import com.spring_security.security_practice.dto.LoginRequestDTO;

public interface AuthService {
    void login(LoginRequestDTO loginRequestDTO);
}
