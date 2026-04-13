package com.foodrescue.optimizer.service;

import com.foodrescue.optimizer.domain.Recipient;
import com.foodrescue.optimizer.repository.RecipientRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RecipientService {
    private final RecipientRepository recipientRepository;

    public Recipient createRecipient(Recipient recipient){
        return recipientRepository.save(recipient);
    }
    public List<Recipient> getAllRecipient(){
        return recipientRepository.findAll();
    }
    public Recipient getRecipientById(UUID id){
        return recipientRepository.findById(id).orElseThrow();
    }


}
