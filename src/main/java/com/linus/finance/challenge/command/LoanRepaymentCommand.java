package com.linus.finance.challenge.command;

public class LoanRepaymentCommand {
    private String loanId;
    private double principalAmount;
    private double interestAmount;

    // Constructor
    public LoanRepaymentCommand(String loanId, double principalAmount, double interestAmount) {
        this.loanId = loanId;
        this.principalAmount = principalAmount;
        this.interestAmount = interestAmount;
    }

    // Getters
    public String getLoanId() {
        return loanId;
    }

    public double getPrincipalAmount() {
        return principalAmount;
    }

    public double getInterestAmount() {
        return interestAmount;
    }

    // Setters
    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public void setPrincipalAmount(double principalAmount) {
        this.principalAmount = principalAmount;
    }

    public void setInterestAmount(double interestAmount) {
        this.interestAmount = interestAmount;
    }
}
