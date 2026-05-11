package com.springlearning.spring_practice_may_26.controllers;

import com.springlearning.spring_practice_may_26.dto.APIResponse;
import com.springlearning.spring_practice_may_26.dto.FoodDTO;
import com.springlearning.spring_practice_may_26.services.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/foods")
@RestController
public class FoodController {
    private final FoodService foodService;

    @GetMapping
    public ResponseEntity<String> getAllFoods(){
        int result = 8/0;
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("User created");
    }

    @PostMapping
    public ResponseEntity<APIResponse<FoodDTO>> createFood(@RequestBody FoodDTO foodDTO){
        FoodDTO savedFood = foodService.createFood(foodDTO);
        String message = "Food Added Successfully";
        APIResponse<FoodDTO> response = new APIResponse<>(message, savedFood);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}
