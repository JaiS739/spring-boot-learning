package com.spring_security.security_practice.controllers;

import com.spring_security.security_practice.dto.APISuccessResponse;
import com.spring_security.security_practice.dto.LoginRequestDTO;
import com.spring_security.security_practice.dto.RegisterUserDTO;
import com.spring_security.security_practice.services.AuthService;
import com.spring_security.security_practice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<APISuccessResponse<Void>> register(@RequestBody RegisterUserDTO user) {
        userService.registerUser(user);
        APISuccessResponse<Void> successResponse = new APISuccessResponse<>(
                LocalDateTime.now().toString(),
                HttpStatus.CREATED.value(),
                true,
                "User registered successfully",
                null
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(successResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<APISuccessResponse<Void>> login(@RequestBody LoginRequestDTO request) {
        authService.login(request);
        APISuccessResponse<Void> response = new APISuccessResponse<>(
                LocalDateTime.now().toString(),
                HttpStatus.OK.value(),
                true,
                "User login successful",
                null
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
