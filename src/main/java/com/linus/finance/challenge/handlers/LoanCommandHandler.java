package com.linus.finance.challenge.handlers;

import com.linus.finance.challenge.aggregate.LoanAggregate;
import com.linus.finance.challenge.command.LoanRepaymentCommand;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.command.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanCommandHandler {
    @Autowired
    private CommandGateway commandGateway;

    @CommandHandler
    public void handle(LoanRepaymentCommand command) {
       commandGateway.sendAndWait(command);
    }
}