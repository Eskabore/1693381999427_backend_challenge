package com.linus.finance.challenge.projection;

import java.util.UUID;

import javax.persistence.Entity;

@Entity
public class LoanView {
    @Id
    private UUID loanId;
    private double principal;
    private double interest;

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

    // Setters
    public void setLoanId(UUID loanId) {
        this.loanId = loanId;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }
}


