package com.linus.finance.challenge.controller;

import com.linus.finance.challenge.projections.LoanView;
import com.linus.finance.challenge.projections.LoanViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/loans")
public class LoanQueryController {

    @Autowired
    private LoanViewRepository loanViewRepository;

    @GetMapping("/{loanId}")
    public ResponseEntity<LoanView> getLoan(@PathVariable String loanId) {
        Optional<LoanView> loanViewOptional = loanViewRepository.findById(loanId);

        if (loanViewOptional.isPresent()) {
            return ResponseEntity.ok(loanViewOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}