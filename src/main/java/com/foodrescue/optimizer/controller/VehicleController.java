package com.foodrescue.optimizer.controller;

import com.foodrescue.optimizer.domain.Vehicle;
import com.foodrescue.optimizer.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle){ return vehicleService.createVehicle(vehicle);}
    @GetMapping
    public List<Vehicle> getAllVehicle(){ return vehicleService.getAllVehicle();}
    @GetMapping("/{id}")
    public Optional<Vehicle> getVehicleById(@PathVariable UUID id){ return vehicleService.getVehicleById(id);}

}
