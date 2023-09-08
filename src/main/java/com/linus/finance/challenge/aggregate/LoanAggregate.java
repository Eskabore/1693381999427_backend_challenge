package com.linus.finance.challenge.aggregate;

import java.util.UUID;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.linus.finance.challenge.command.CreateLoanCommand;
import com.linus.finance.challenge.command.LoanRepaymentCommand;
import com.linus.finance.challenge.event.LoanCreatedEvent;
import com.linus.finance.challenge.event.LoanRepaymentEvent;

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

    // Command-handling constructor for CreateLoanCommand
    @CommandHandler
    public LoanAggregate(CreateLoanCommand command) {
        // Set the loanId from the command
        this.loanId = command.getLoanId();
        this.principal = command.getPrincipal();
        this.interest = command.getInterest();
        // Emit an event to signify that a loan has been created
        AggregateLifecycle.apply(new LoanCreatedEvent(command.getLoanId(), command.getPrincipal(), command.getInterest()));
    }

    // Command-handling method for LoanRepaymentCommand
    @CommandHandler
    public void handle(LoanRepaymentCommand command) {
        // Validation logic here

        // Emit an event to signify that a repayment has been made
        AggregateLifecycle.apply(new LoanRepaymentEvent(command.getLoanId(), command.getRepaymentAmount()));
    }

    // Event-sourcing handler for LoanCreatedEvent
    @EventSourcingHandler
    public void on(LoanCreatedEvent event) {
        this.loanId = event.getLoanId();
        this.principal = event.getPrincipal();
        this.interest = event.getInterest();
        // Update other fields
    }

    // Event-sourcing handler for LoanRepaymentEvent
    @EventSourcingHandler
    public void on(LoanRepaymentEvent event) {
        // Update the state based on the repayment
        // For example, you might update the remaining balance
    }
}
