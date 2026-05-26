package com.springlearning.spring_practice_may_26.services;

import com.springlearning.spring_practice_may_26.dto.LoginDTO;
import com.springlearning.spring_practice_may_26.dto.LoginResponseDTO;

public interface AuthService {
    LoginResponseDTO login(LoginDTO loginDTO);

    LoginResponseDTO refreshToken(String refreshToken);
}
