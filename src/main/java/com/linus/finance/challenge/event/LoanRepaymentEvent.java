package com.linus.finance.challenge.event;

import java.util.UUID;

public class LoanRepaymentEvent {

    private final UUID loanId;
    private final double repaymentAmount;

    // Constructor
    public LoanRepaymentEvent(UUID loanId, double repaymentAmount) {
        this.loanId = loanId;
        this.repaymentAmount = repaymentAmount;
    }

    // Getters
    public UUID getLoanId() {
        return loanId;
    }

    public double getRepaymentAmount() {
        return repaymentAmount;
    }
}
