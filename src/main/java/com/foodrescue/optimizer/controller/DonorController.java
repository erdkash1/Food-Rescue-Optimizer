package com.foodrescue.optimizer.controller;

import com.foodrescue.optimizer.domain.Donor;
import com.foodrescue.optimizer.service.DonorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/donors")
@RequiredArgsConstructor
public class DonorController {
    private final DonorService donorService;

    @PostMapping
    public Donor createDonor(@RequestBody Donor donor){ return donorService.createDonor(donor);}
}
