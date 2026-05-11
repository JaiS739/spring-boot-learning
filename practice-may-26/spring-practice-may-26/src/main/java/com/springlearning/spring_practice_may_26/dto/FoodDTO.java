package com.springlearning.spring_practice_may_26.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodDTO {

    private String restaurant;

    private String food;

    private Integer price;

    private Double rating;
}
