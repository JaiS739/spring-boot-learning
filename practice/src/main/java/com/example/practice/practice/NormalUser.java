package com.example.practice.practice;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name="user.type", havingValue="Normal" )
public class NormalUser implements User{
    @Override
    public String userType(){
        return "This is normal user";
    }
}
