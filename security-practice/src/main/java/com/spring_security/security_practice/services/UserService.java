package com.spring_security.security_practice.services;

import com.spring_security.security_practice.dto.RegisterUserDTO;

public interface UserService {
    void registerUser(RegisterUserDTO user);
}
