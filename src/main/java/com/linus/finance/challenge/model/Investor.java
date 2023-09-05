package com.linus.finance.challenge.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Investor {
    @NotEmpty(message = "Investor ID cannot be empty")
    private String id;

    @NotEmpty(message = "Investor name cannot be empty")
    private String name;

    @NotNull(message = "Amount invested cannot be null")
    @Min(value = 0, message = "Amount invested should be positive")
    private Double amountInvested;

    @NotNull(message = "Interest cannot be null")
    @Min(value = 0, message = "Interest should be positive")
    private Double interest;

    @NotEmpty(message = "Loan ID cannot be empty")
    private String loanId;

    // Constructor
    public Investor(String id, String name, Double amountInvested, Double interest, String loanId) {
        this.id = id;
        this.name = name;
        this.amountInvested = amountInvested;
        this.interest = interest;
        this.loanId = loanId;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getAmountInvested() {
        return amountInvested;
    }

    public Double getInterest() {
        return interest;
    }

    public String getLoanId() {
        return loanId;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmountInvested(Double amountInvested) {
        this.amountInvested = amountInvested;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }
}
