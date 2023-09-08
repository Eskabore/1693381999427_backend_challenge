package com.linus.finance.challenge.aggregate;

import java.util.UUID;

import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class LoanAggregate {

    @AggregateIdentifier
    private UUID loanId;
    private double amount;
    private double interestRate;
    // other fields

    // No-arg constructor
    protected LoanAggregate() {
    }

    // Command-handling constructors and methods
    // ...

    // Event-sourcing handlers
    // ...

}