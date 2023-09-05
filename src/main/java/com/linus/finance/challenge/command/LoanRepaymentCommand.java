package com.linus.finance.challenge.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class LoanRepaymentCommand {
    @TargetAggregateIdentifier
    @NotEmpty(message = "Loan ID cannot be empty")
    private String loanId;
    @NotNull(message = "Principal amount cannot be null")
    @Min(value = 0, message = "Principal amount should be positive")
    private Double principalAmount;

    @NotNull(message = "Interest amount cannot be null")
    @Min(value = 0, message = "Interest amount should be positive")
    private Double interestAmount;

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
