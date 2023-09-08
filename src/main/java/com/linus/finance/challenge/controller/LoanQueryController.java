package com.linus.finance.challenge.controller;

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