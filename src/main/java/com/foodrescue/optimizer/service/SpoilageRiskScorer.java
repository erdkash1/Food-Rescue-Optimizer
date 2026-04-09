package com.foodrescue.optimizer.service;

import com.foodrescue.optimizer.domain.FoodItem;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import smile.classification.LogisticRegression;

@Service
public class SpoilageRiskScorer {
    private LogisticRegression model;

    @PostConstruct
    public void train(){
        double[][] x = {
                {0, 20, 48},
                {0, 35, 3},
                {1, 20, 24},
                {1, 25, 6},
                {1, 30, 2},
                {2, 20, 36},
                {2, 35, 4},
                {0, 20, 72},
                {1, 15, 48},
                {2, 30, 6}
        };
        int[] y = {0, 1, 0, 1, 1, 0, 1, 0, 0, 1};

        model = LogisticRegression.fit(x, y);

    }

    public Double score(FoodItem foodItem, double temperature){
        double categoryValue = switch (foodItem.getFoodCategory()){
            case BREAD -> 0.0;
            case DAIRY -> 1.0;
            case PRODUCE -> 2.0;
        };
        double hoursUntilExpiry = java.time.Duration.between(
                java.time.LocalDateTime.now(),
                foodItem.getExpiresAt()
        ).toHours();
        if (hoursUntilExpiry <= 0) {
            return 1.0;
        }

        double[] features = {categoryValue, hoursUntilExpiry, temperature};
        double[] posteriori = new double[2];
        model.predict(features, posteriori);
        return posteriori[1]; // probability of class 1 (spoiled)

    }

}
