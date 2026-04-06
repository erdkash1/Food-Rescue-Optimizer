package com.foodrescue.optimizer.repository;

import com.foodrescue.optimizer.domain.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RouteRepository extends JpaRepository<Route, UUID> {
}
