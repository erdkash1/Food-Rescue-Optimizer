package com.foodrescue.optimizer.service;

import ai.timefold.solver.core.api.solver.SolverJob;
import ai.timefold.solver.core.api.solver.SolverManager;
import com.foodrescue.optimizer.domain.FoodItem;
import com.foodrescue.optimizer.domain.RoutePlan;
import com.foodrescue.optimizer.domain.RouteStop;
import com.foodrescue.optimizer.domain.Vehicle;
import com.foodrescue.optimizer.repository.FoodItemRepository;
import com.foodrescue.optimizer.repository.RouteStopRepository;
import com.foodrescue.optimizer.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RouteOptimizerService {
    private final RouteStopRepository routeStopRepository;
    private final VehicleRepository vehicleRepository;
    private final FoodItemRepository foodItemRepository;
    private final SolverManager<RoutePlan, UUID> solverManager;



    public RoutePlan optimizeRoute() throws Exception{
        List<FoodItem> foodItems = foodItemRepository.findAll();
        List<Vehicle> vehicle = vehicleRepository.findAll();
        List<RouteStop> routeStop = buildRouteStops(foodItems);

        RoutePlan routePlan = new RoutePlan();
        routePlan.setVehicles(vehicle);
        routePlan.setRouteStops(routeStop);

        UUID problemId = UUID.randomUUID();
        SolverJob<RoutePlan, UUID> solverJob = solverManager.solve(problemId, routePlan);
        return solverJob.getFinalBestSolution();

    }

    private List<RouteStop> buildRouteStops(List<FoodItem> foodItems) {
        return foodItems.stream()
                .map(foodItem -> RouteStop.builder()
                        .foodItem(foodItem)
                .stopType(RouteStop.StopType.PICKUP)
            .build())
        .collect(Collectors.toList());
    }
}
