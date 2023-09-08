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

    // Command-handling constructors and methods
    @CommandHandler
    public LoanAggregate(CreateLoanCommand command) {
        AggregateLifecycle
                .apply(new LoanCreatedEvent(command.getLoanId(), command.getPrincipal(), command.getInterest()));
    }

    // Event-sourcing handlers
    @EventSourcingHandler
    public void on(LoanCreatedEvent event) {
        this.loanId = event.getLoanId();
        this.principal = event.getPrincipal();
        this.interest = event.getInterest();
        // Update other fields
    }

    // Command-handling methods
    @EventSourcingHandler
    public void on(LoanRepaymentEvent event) {
        // Update other fields
    }

}