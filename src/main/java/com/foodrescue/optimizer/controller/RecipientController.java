package com.foodrescue.optimizer.controller;

import com.foodrescue.optimizer.domain.Recipient;
import com.foodrescue.optimizer.service.RecipientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/recipients")

public class RecipientController {
    private final RecipientService recipientService;

    @PostMapping
    public Recipient createRecipient(@RequestBody Recipient recipient){ return recipientService.createRecipient(recipient);}

    @GetMapping
    public List<Recipient> getAllRecipient(){ return recipientService.getAllRecipient();}

    @GetMapping("/{id}")
    public Optional<Recipient> getRecipientById(@PathVariable UUID id){ return recipientService.getRecipientById(id);}
}



