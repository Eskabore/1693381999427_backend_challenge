package com.linus.finance.challenge.command;

public class CreateLoanCommand {
    private final String loanId;
    private final double initialAmount;

    public CreateLoanCommand(String loanId, double initialAmount) {
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