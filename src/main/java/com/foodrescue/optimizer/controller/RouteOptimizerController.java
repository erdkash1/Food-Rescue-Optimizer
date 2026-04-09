package com.foodrescue.optimizer.controller;

import com.foodrescue.optimizer.domain.RoutePlan;
import com.foodrescue.optimizer.service.RouteOptimizerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/optimize")
@RequiredArgsConstructor
public class RouteOptimizerController {

    private final RouteOptimizerService routeOptimizerService;

    @PostMapping
    public RoutePlan optimize() throws Exception{
        return routeOptimizerService.optimizeRoute();
    }
}
