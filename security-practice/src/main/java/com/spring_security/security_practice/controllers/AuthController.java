package com.spring_security.security_practice.controllers;

import com.spring_security.security_practice.dto.RegisterUserDTO;
import com.spring_security.security_practice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterUserDTO user){
        userService.registerUser(user);
        return "User Register Successfully";
    }
}
