package com.example.practice.practice;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name="user.type", havingValue = "Admin")
public class Admin implements User {
    @Override
    public String userType(){
        return "This is is Admin user";
    }
}
