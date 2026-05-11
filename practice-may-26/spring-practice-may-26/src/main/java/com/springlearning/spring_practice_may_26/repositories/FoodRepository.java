package com.springlearning.spring_practice_may_26.repositories;

import com.springlearning.spring_practice_may_26.entities.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<FoodEntity, Long> {
}
