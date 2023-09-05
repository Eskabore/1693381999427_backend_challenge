package com.linus.finance.challenge.projections;

import com.linus.finance.challenge.event.LoanRepaymentEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoanProjection {

    @Autowired
    private LoanViewRepository loanViewRepository;

    @EventHandler
    public void on(LoanRepaymentEvent event) {
        LoanView loanView = loanViewRepository.findById(event.getLoanId())
                .orElse(new LoanView(event.getLoanId()));

        loanView.setRemainingPrincipal(loanView.getRemainingPrincipal() - event.getPrincipalAmount());
        loanView.setRemainingInterest(loanView.getRemainingInterest() - event.getInterestAmount());

        loanViewRepository.save(loanView);
    }
}
