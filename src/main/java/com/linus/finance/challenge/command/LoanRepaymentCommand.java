package com.linus.finance.challenge.command;

import java.util.UUID;

public class LoanRepaymentCommand {

    private final UUID loanId;
    private final double repaymentAmount;

    public LoanRepaymentCommand(UUID loanId, double repaymentAmount) {
        this.loanId = loanId;
        this.repaymentAmount = repaymentAmount;
    }

    // Getters and setters
    public UUID getLoanId() {
        return loanId;
    }

    public double getRepaymentAmount() {
        return repaymentAmount;
    }
}