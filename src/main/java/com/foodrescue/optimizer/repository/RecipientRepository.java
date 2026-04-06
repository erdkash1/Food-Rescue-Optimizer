package com.foodrescue.optimizer.repository;

import com.foodrescue.optimizer.domain.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RecipientRepository extends JpaRepository<Recipient, UUID> {
}
