package com.foodrescue.optimizer.domain;

import ai.timefold.solver.core.api.domain.solution.PlanningEntityCollectionProperty;
import ai.timefold.solver.core.api.domain.solution.PlanningScore;
import ai.timefold.solver.core.api.domain.solution.PlanningSolution;
import ai.timefold.solver.core.api.domain.solution.ProblemFactCollectionProperty;
import ai.timefold.solver.core.api.score.buildin.hardsoft.HardSoftScore;

import java.util.List;

@PlanningSolution
public class RoutePlan {


    @ProblemFactCollectionProperty
    private List<Vehicle> vehicles;
    @PlanningEntityCollectionProperty
    private List<RouteStop> routeStops;
    @PlanningScore
    private HardSoftScore score;

    public List<Vehicle> getVehicles() {return vehicles;}
    public void setVehicles(List<Vehicle> vehicles) {this.vehicles = vehicles;}

    public HardSoftScore getScore() {return score;}
    public void setScore(HardSoftScore score) {this.score = score;}

    public List<RouteStop> getRouteStops() {return routeStops;}
    public void setRouteStops(List<RouteStop> routeStops) {this.routeStops = routeStops;}

}

