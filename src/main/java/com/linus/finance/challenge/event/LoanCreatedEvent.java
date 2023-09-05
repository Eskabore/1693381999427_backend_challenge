package com.linus.finance.challenge.event;

public class LoanCreatedEvent {
    private final String loanId;
    private final double initialAmount;

    // Constructor
    public LoanCreatedEvent(String loanId, double initialAmount) {
        this.loanId = loanId;
        this.initialAmount = initialAmount;
    }

    public String getLoanId() {
        return loanId;
    }

    public double getInitialAmount() {
        return initialAmount;
    }
}