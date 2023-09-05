package com.linus.finance.challenge.projections;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoanView {
    @Id
    private String loanId;
    private double remainingPrincipal;
    private double remainingInterest;

    // Default constructor for JPA
    public LoanView() {}

    // Constructor using loanId
    public LoanView(String loanId) {
        this.loanId = loanId;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public double getRemainingPrincipal() {
        return remainingPrincipal;
    }

    public void setRemainingPrincipal(double remainingPrincipal) {
        this.remainingPrincipal = remainingPrincipal;
    }

    public double getRemainingInterest() {
        return remainingInterest;
    }

    public void setRemainingInterest(double remainingInterest) {
        this.remainingInterest = remainingInterest;
    }
}