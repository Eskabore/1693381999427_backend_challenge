package com.linus.finance.challenge.aggregate;

import com.linus.finance.challenge.command.LoanRepaymentCommand;
import com.linus.finance.challenge.event.LoanRepaymentEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class LoanAggregate {
    @AggregateIdentifier
    private Long loanId;
    private double remainingPrincipal;
    private  double remainingInterest;

    // Default Axon Constructor
    protected LoanAggregate() {}

    // CommandHandler for repaying loan
    @CommandHandler
    public void handle(LoanRepaymentCommand command) {
        // Business logic to repay the loan
        if (remainingPrincipal < command.getPrincipalAmount() || remainingInterest < command.getInterestAmount()) {
            throw new IllegalArgumentException("Repayment amounts exceed remaining amounts");
        } else {
            AggregateLifecycle.apply(new LoanRepaymentEvent(command.getLoanId(), command.getPrincipalAmount(), command.getInterestAmount()));
        }
    }

    @EventSourcingHandler
    public void on(LoanRepaymentEvent event) {
        this.remainingPrincipal -= event.getPrincipalAmount();
        this.remainingInterest -= event.getInterestAmount();
    }

    // Constructors, getters, setters,...
}
