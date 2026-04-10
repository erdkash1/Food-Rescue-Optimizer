package com.foodrescue.optimizer.service;

import com.foodrescue.optimizer.domain.Donor;
import com.foodrescue.optimizer.repository.DonorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DonorService {
    private final DonorRepository donorRepository;

    public Donor createDonor(Donor donor){
        return donorRepository.save(donor);
    }
    public List<Donor> getAllDonor(){
        return donorRepository.findAll();
    }

    public Optional<Donor> getDonorById(UUID id){
        return donorRepository.findById(id);
    }
}
