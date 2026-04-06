package com.foodrescue.optimizer.repository;

import com.foodrescue.optimizer.domain.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FoodItemRepository extends JpaRepository<FoodItem, UUID> {
}
