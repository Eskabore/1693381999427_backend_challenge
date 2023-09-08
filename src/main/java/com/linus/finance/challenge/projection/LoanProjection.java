package com.linus.finance.challenge.projection;

import org.axonframework.eventhandling.EventHandler;

import com.linus.finance.challenge.event.LoanCreatedEvent;
import com.linus.finance.challenge.event.LoanRepaymentEvent;
import com.linus.finance.challenge.repository.LoanViewRepository;

public class LoanProjection {

    @EventHandler
    public void on(LoanCreatedEvent event, LoanViewRepository repository) {
        LoanView loanView = new LoanView();
        loanView.setLoanId(event.getLoanId());
        loanView.setPrincipal(event.getPrincipal());
        loanView.setInterest(event.getInterest());
        // set other fields

        repository.save(loanView);
    }

    @EventHandler
    public void on(LoanRepaymentEvent event, LoanViewRepository repository) {
        // Update the LoanView based on the repayment event
    }
}
