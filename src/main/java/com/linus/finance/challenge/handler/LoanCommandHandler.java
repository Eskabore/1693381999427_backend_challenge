package com.linus.finance.challenge.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import com.linus.finance.challenge.command.CreateLoanCommand;

@Service
public class LoanCommandHandler {

    @Autowired
    private CommandGateway commandGateway;

    public void handleCreateLoan(CreateLoanCommand command) {
        commandGateway.send(command);
    }

    // Add more methods to handle other commands
}