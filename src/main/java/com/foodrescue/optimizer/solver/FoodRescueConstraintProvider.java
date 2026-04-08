package com.foodrescue.optimizer.solver;

import ai.timefold.solver.core.api.score.buildin.hardsoft.HardSoftScore;
import ai.timefold.solver.core.api.score.stream.Constraint;
import ai.timefold.solver.core.api.score.stream.ConstraintCollectors;
import ai.timefold.solver.core.api.score.stream.ConstraintFactory;
import ai.timefold.solver.core.api.score.stream.ConstraintProvider;
import com.foodrescue.optimizer.domain.RouteStop;



public class FoodRescueConstraintProvider implements  ConstraintProvider{

    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[] {
                vehicleCapacity(constraintFactory)
        };


    }
    private Constraint vehicleCapacity(ConstraintFactory factory) {
        return factory.forEach(RouteStop.class)
                .filter(stop -> stop.getFoodItem() != null)
                .groupBy(RouteStop::getVehicle,
                        ConstraintCollectors.sum(
                                stop -> stop.getFoodItem().getQuantityKg().intValue()))
                .filter((vehicle, totalWeight) ->
                        totalWeight > vehicle.getCapacityKg().intValue())
                .penalize(HardSoftScore.ONE_HARD)
                .asConstraint("Vehicle capacity");
    }

}
