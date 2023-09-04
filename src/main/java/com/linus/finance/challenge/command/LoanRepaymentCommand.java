package com.linus.finance.challenge.command;

public class LoanRepaymentCommand {
    private Long loanId;
    private double principalAmount;
    private double interestAmount;

    // Constructor

    // Getters
    public Long getLoanId() {
        return loanId;
    }

    public double getPrincipalAmount() {
        return principalAmount;
    }

    public double getInterestAmount() {
        return interestAmount;
    }

    // Setters
    public Long setLoanId(Long loanId) {
        return this.loanId = loanId;
    }

    public void setPrincipalAmount(double principalAmount) {
        this.principalAmount = principalAmount;
    }

    public void setInterestAmount(double interestAmount) {
        this.interestAmount = interestAmount;
    }
}
