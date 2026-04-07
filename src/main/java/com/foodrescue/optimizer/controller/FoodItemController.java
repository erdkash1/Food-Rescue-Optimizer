package com.foodrescue.optimizer.controller;

import com.foodrescue.optimizer.domain.FoodItem;
import com.foodrescue.optimizer.service.FoodItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/donors/{donorId}/food-items")
@RequiredArgsConstructor
public class FoodItemController {
    private final FoodItemService foodItemService;

    @PostMapping
    public FoodItem createFoodItem(@RequestBody FoodItem foodItem, @PathVariable UUID donorId){
        return foodItemService.createFoodItem(foodItem, donorId);

    }
}
