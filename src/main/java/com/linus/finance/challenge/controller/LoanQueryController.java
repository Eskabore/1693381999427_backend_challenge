package com.linus.finance.challenge.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.linus.finance.challenge.projection.LoanView;
import com.linus.finance.challenge.repository.LoanViewRepository;

@RestController
@RequestMapping("/loan-views")
public class LoanQueryController {

    private final LoanViewRepository repository;

    public LoanQueryController(LoanViewRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanView> getLoanView(@PathVariable UUID id) {
        Optional<LoanView> loanView = repository.findById(id);
        return loanView.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Other endpoints to handle other queries
}