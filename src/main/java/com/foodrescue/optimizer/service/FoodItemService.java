package com.foodrescue.optimizer.service;


import com.foodrescue.optimizer.domain.FoodItem;
import com.foodrescue.optimizer.repository.FoodItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class FoodItemService {
    private final FoodItemRepository foodItemRepository;

    public FoodItem createFoodItem(FoodItem foodItem){
        return foodItemRepository.save(foodItem);
    }
}
