package com.foodrescue.optimizer.service;

import com.foodrescue.optimizer.domain.Donor;
import com.foodrescue.optimizer.domain.FoodItem;
import com.foodrescue.optimizer.repository.DonorRepository;
import com.foodrescue.optimizer.repository.FoodItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FoodItemServiceTest {
    @Mock
    private FoodItemRepository foodItemRepository;
    @Mock
    private DonorRepository donorRepository;
    @Mock
    private SpoilageRiskScorer spoilageRiskScorer;

    @InjectMocks
    private FoodItemService foodItemService;

    @Test
    void whenFoodItemIsCreated_thenSpoilageScoreShouldBeSet() {
        // arrange
        UUID donorId = UUID.randomUUID();
        Donor fakeDonor = Donor.builder()
                .id(donorId)
                .name("Test Donor")
                .email("test@test.com")
                .latitude(40.7128)
                .longitude(-74.0060)
                .build();

        FoodItem fakeFoodItem = FoodItem.builder()
                .description("Fresh Milk")
                .quantityKg(new BigDecimal("10.0"))
                .availableFrom(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusHours(24))
                .foodCategory(FoodItem.FoodCategory.DAIRY)
                .build();

        when(donorRepository.findById(donorId)).thenReturn(Optional.of(fakeDonor));
        when(foodItemRepository.save(any())).thenReturn(fakeFoodItem);
        when(spoilageRiskScorer.score(any(), anyDouble())).thenReturn(0.8);

        // act
        FoodItem result = foodItemService.createFoodItem(fakeFoodItem, donorId);

        // assert
        verify(spoilageRiskScorer, times(1)).score(any(), anyDouble());
        assertThat(result).isNotNull();
    }


    @Test
    void whenDonorNotFound_thenThrowException() {
        UUID donorId = UUID.randomUUID();
        FoodItem fakeFoodItem = FoodItem.builder()
                .description("Fresh Milk")
                .quantityKg(new BigDecimal("10.0"))
                .availableFrom(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusHours(24))
                .foodCategory(FoodItem.FoodCategory.DAIRY)
                .build();

        when(donorRepository.findById(donorId)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> foodItemService.createFoodItem(fakeFoodItem, donorId))
                .isInstanceOf(java.util.NoSuchElementException.class);
    }

}
