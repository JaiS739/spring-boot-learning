package com.example.practice.practice;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name="animal.provider", havingValue = "dog")
public class Dog implements Animal {
    @Override
    public String eating(){
        return "Dog eats bone";
    }
}
