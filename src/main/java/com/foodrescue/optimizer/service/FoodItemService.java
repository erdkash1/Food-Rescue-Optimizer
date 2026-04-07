package com.foodrescue.optimizer.service;


import com.foodrescue.optimizer.domain.Donor;
import com.foodrescue.optimizer.domain.FoodItem;
import com.foodrescue.optimizer.repository.DonorRepository;
import com.foodrescue.optimizer.repository.FoodItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class FoodItemService {
    private final FoodItemRepository foodItemRepository;
    private final DonorRepository donorRepository;

    public FoodItem createFoodItem(FoodItem foodItem, UUID donorId){
        Donor donor = donorRepository.findById(donorId).orElseThrow();
        foodItem.setDonor(donor);
        return foodItemRepository.save(foodItem);
    }
}
