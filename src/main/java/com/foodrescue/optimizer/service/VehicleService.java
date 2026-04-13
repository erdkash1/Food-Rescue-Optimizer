package com.foodrescue.optimizer.service;

import com.foodrescue.optimizer.domain.Vehicle;
import com.foodrescue.optimizer.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public Vehicle createVehicle(Vehicle vehicle){ return vehicleRepository.save(vehicle);}
    public List<Vehicle> getAllVehicle(){ return vehicleRepository.findAll();}
    public Vehicle getVehicleById(UUID id){ return vehicleRepository.findById(id).orElseThrow();}

}
