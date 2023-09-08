package com.linus.finance.challenge.event;

import java.util.UUID;

public class LoanCreatedEvent {

    private final UUID loanId;
    private final double principal;
    private final double interest;
    // other fields

    public LoanCreatedEvent(UUID loanId, double principal, double interest) {
        this.loanId = loanId;
        this.principal = principal;
        this.interest = interest;
    }

    // Getters
    public UUID getLoanId() {
        return loanId;
    }

    public double getPrincipal() {
        return principal;
    }

    public double getInterest() {
        return interest;
    }
}

