package com.linus.finance.challenge.aggregate;

import com.linus.finance.challenge.command.CreateLoanCommand;
import com.linus.finance.challenge.command.LoanRepaymentCommand;
import com.linus.finance.challenge.event.LoanCreatedEvent;
import com.linus.finance.challenge.event.LoanRepaymentEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class LoanAggregate {
    @AggregateIdentifier
    private String loanId;
    private double remainingPrincipal;
    private double remainingInterest;

    // Default Axon Constructor
    protected LoanAggregate() {}

    // CommandHandler for creating a loan
    @CommandHandler
    public LoanAggregate(CreateLoanCommand command) {
        AggregateLifecycle.apply(new LoanCreatedEvent(command.getLoanId(), command.getInitialAmount()));
    }

    @EventSourcingHandler
    public void on(LoanCreatedEvent event) {
        this.loanId = event.getLoanId();
        this.remainingPrincipal = event.getInitialAmount();
        // Assuming the loan starts with no interest
        this.remainingInterest = 10; // Set initial interest
        System.out.println("LoanCreatedEvent handled. Remaining Principal: " + this.remainingPrincipal);
    }

    // CommandHandler for repaying loan
    @CommandHandler
    public void handle(LoanRepaymentCommand command) {
        if (this.loanId == null) {
            this.loanId = command.getLoanId();
        }
        repay(command.getPrincipalAmount(), command.getInterestAmount());
    }

    @EventSourcingHandler
    public void on(LoanRepaymentEvent event) {
        this.remainingPrincipal -= event.getPrincipalAmount();
        this.remainingInterest -= event.getInterestAmount();
        System.out.println("LoanRepaymentEvent handled. Remaining Principal: " + this.remainingPrincipal + ", Remaining Interest: " + this.remainingInterest);
    }

    public void repay(double principalAmount, double interestAmount) {
        if (remainingPrincipal < principalAmount || remainingInterest < interestAmount) {
            throw new IllegalArgumentException("Repayment amounts exceed remaining amounts");
        } else {
            AggregateLifecycle.apply(new LoanRepaymentEvent(this.loanId, principalAmount, interestAmount));System.out.println("Repay called. Principal Amount: " + principalAmount + ", Interest Amount: " + interestAmount);
            System.out.println("Repay called. Principal Amount: " + principalAmount + ", Interest Amount: " + interestAmount);
        }
    }
}