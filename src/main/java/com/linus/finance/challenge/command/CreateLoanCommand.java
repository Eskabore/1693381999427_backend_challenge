package com.linus.finance.challenge.command;

public class CreateLoanCommand {

    private final UUID loanId;
    private final double amount;
    private final double interestRate;
    // other fields

    // Getters and setters
    // ...
}

// LoanRepaymentCommand.java
public class LoanRepaymentCommand {

    private final UUID loanId;
    private final double repaymentAmount;
    // other fields

    // Getters and setters
    // ...
}
