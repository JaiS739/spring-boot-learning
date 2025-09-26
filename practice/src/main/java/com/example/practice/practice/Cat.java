package com.example.practice.practice;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name="animal.provider", havingValue = "cat")
public class Cat implements Animal {
    @Override
    public String eating(){
        return "Cat eats fish";
    }
}
