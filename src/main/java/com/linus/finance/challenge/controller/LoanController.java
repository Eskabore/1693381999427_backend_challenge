package com.linus.finance.challenge.controller;

import com.linus.finance.challenge.command.LoanRepaymentCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loans")
public class LoanController {
    @Autowired
    private CommandGateway commandGateway;

    @PostMapping("/{loanId}/repay")
    public ResponseEntity<Void> repayLoan(@PathVariable String loanId, @RequestBody LoanRepaymentCommand command) {
        try {
            commandGateway.sendAndWait(command);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build(); // Handle exceptions appropriately
        }
    }
}
