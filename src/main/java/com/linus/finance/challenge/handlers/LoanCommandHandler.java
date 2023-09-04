package com.linus.finance.challenge.handlers;

import com.linus.finance.challenge.command.LoanRepaymentCommand;
import com.linus.finance.challenge.model.Loan;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanCommandHandler {
    @Autowired
    private Repository<Loan> loanRepository;

    @CommandHandler
    public void handle(LoanRepaymentCommand command) {
        Loan loan = loanRepository.load(command.getLoanId());
        loan.repay(command.getPrincipalAmount(), command.getInterestAmount());
    }
}
