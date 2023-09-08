package com.linus.finance.challenge.handler;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linus.finance.challenge.event.LoanCreatedEvent;
import com.linus.finance.challenge.projection.LoanView;
import com.linus.finance.challenge.repository.LoanViewRepository;

@Service
public class LoanEventHandler {

    @Autowired
    private LoanViewRepository repository;

    @EventHandler
    public void on(LoanCreatedEvent event) {
        LoanView loanView = new LoanView();
        loanView.setLoanId(event.getLoanId());
        loanView.setPrincipal(event.getPrincipal());
        loanView.setInterest(event.getInterest());
        // set other fields

        repository.save(loanView);
    }
}

