package com.linus.finance.challenge.projection;

import java.util.UUID;

public class LoanView {

    private UUID loanId;
    private double principal;
    private double interest;

    // Getters
    // ...

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


