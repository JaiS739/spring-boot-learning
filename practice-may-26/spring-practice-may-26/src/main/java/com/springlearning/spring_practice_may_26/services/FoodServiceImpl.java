package com.springlearning.spring_practice_may_26.services;

import com.springlearning.spring_practice_may_26.dto.FoodDTO;
import com.springlearning.spring_practice_may_26.entities.FoodEntity;
import com.springlearning.spring_practice_may_26.repositories.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;

    private final ModelMapper modelMapper;

    @Override
    public FoodDTO createFood(FoodDTO food){
        FoodEntity foodEntity = modelMapper.map(food, FoodEntity.class);
        FoodEntity savedFood = foodRepository.save(foodEntity);
        return modelMapper.map(savedFood, FoodDTO.class);
    }
}
