package com.linus.finance.challenge.aggregate;

import java.util.UUID;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.linus.finance.challenge.command.CreateLoanCommand;
import com.linus.finance.challenge.command.LoanRepaymentCommand;

@Aggregate
public class LoanAggregate {

    @AggregateIdentifier
    private UUID loanId;
    private double principal;
    private double interest;
    // other fields

    // No-arg constructor
    protected LoanAggregate() {
    }

    // Command-handling constructors and methods
    @CommandHandler
    public LoanAggregate(CreateLoanCommand command) {
        AggregateLifecycle.apply(new LoanCreatedEvent(command.getLoanId(), command.getPrincipal(), command.getInterest()));
    }

    // Event-sourcing handlers
    // ...

}