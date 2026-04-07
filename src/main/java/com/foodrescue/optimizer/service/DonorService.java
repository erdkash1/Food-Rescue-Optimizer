package com.foodrescue.optimizer.service;

import com.foodrescue.optimizer.domain.Donor;
import com.foodrescue.optimizer.repository.DonorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DonorService {
    private final DonorRepository donorRepository;

    public Donor createDonor(Donor donor){
        return donorRepository.save(donor);
    }

}
