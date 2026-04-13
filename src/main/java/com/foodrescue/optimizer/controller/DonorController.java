package com.foodrescue.optimizer.controller;

import com.foodrescue.optimizer.domain.Donor;
import com.foodrescue.optimizer.service.DonorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/donors")
@RequiredArgsConstructor
public class DonorController {
    private final DonorService donorService;

    @PostMapping
    public Donor createDonor(@RequestBody Donor donor){ return donorService.createDonor(donor);}

    @GetMapping
    public List<Donor> getAllDonor(){ return donorService.getAllDonor();}

    @GetMapping("/{id}")
    public Donor getDonorById(@PathVariable UUID id){ return donorService.getDonorById(id);}
}
