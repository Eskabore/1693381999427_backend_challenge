package com.linus.finance.challenge.controller;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import com.linus.finance.challenge.command.CreateLoanCommand;

@RestController
@RequestMapping("/loans")
public class LoanController {

    private final CommandGateway commandGateway;

    public LoanController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public ResponseEntity<Void> createLoan(@RequestBody CreateLoanCommand command) {
        commandGateway.send(command);
        return ResponseEntity.ok().build();
    }

    // Other endpoints to handle other commands
}
