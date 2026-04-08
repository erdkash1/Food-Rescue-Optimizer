package com.foodrescue.optimizer.domain;

import ai.timefold.solver.core.api.domain.entity.PlanningEntity;
import ai.timefold.solver.core.api.domain.variable.PlanningVariable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@PlanningEntity
@Entity
@Table(name = "route_stops")
public class RouteStop {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @PlanningVariable
    private Vehicle vehicle;
    @ManyToOne
    private FoodItem foodItem;
    @ManyToOne
    private Recipient recipient;

    private Integer stopOrder;
    @Enumerated(EnumType.STRING)
    private StopType stopType;

    public enum StopType{
        PICKUP, DROPOFF
    }
}
