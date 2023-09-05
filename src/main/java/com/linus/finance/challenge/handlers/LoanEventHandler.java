package com.linus.finance.challenge.handlers;

import com.linus.finance.challenge.event.LoanRepaymentEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
public class LoanEventHandler {
    @EventHandler
    public void handle(LoanRepaymentEvent event) {
        // Logic to distribute the repaid amount among investors
        // Temporary print
        System.out.println("Loan repaid: " + event.getPrincipalAmount() + " principal and " + event.getInterestAmount() + " interest");
    }
}