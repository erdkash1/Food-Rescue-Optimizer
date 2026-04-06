package com.foodrescue.optimizer.repository;

import com.foodrescue.optimizer.domain.Donor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DonorRepository extends JpaRepository<Donor, UUID> {
}
