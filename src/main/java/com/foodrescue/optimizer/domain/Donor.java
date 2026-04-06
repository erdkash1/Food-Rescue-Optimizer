package com.foodrescue.optimizer.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Entity
@Table(name = "donors")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Donor {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String email;
    private double latitude;
    private double longitude;


}
