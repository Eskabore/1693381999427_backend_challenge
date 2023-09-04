package com.linus.finance.challenge.event;

public class LoanRepaymentEvent {
    private final String loanId;
    private final double principalAmount;
    private final double interestAmount;

    // Constructor
    public LoanRepaymentEvent(String loanId, double principalAmount, double interestAmount) {
        this.loanId = loanId;
        this.principalAmount =principalAmount;
        this.interestAmount = interestAmount;
    }

    public String getLoanId() {
        return loanId;
    }

    public double getPrincipalAmount() {
        return principalAmount;
    }
    public double getInterestAmount() {
        return interestAmount;
    }

}