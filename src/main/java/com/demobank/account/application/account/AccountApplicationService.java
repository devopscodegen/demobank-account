package com.demobank.account.application.account;

import org.springframework.stereotype.Service;

import com.demobank.account.domain.model.account.Transaction;
import com.demobank.account.domain.model.account.TransactionStatus;

@Service
public class AccountApplicationService {

    public Transaction withdraw(WithdrawCommand aCommand) {
        return new Transaction(
            aCommand.getAccountId(), 
            aCommand.getAmount(), 
            aCommand.getCurrency(), 
            TransactionStatus.SUCCESS, 
            "12345678", 
            100.0 - aCommand.getAmount(), 
            "USD");
    }

    public Transaction deposit(DepositCommand aCommand) {
        return new Transaction(
            aCommand.getAccountId(), 
            aCommand.getAmount(), 
            aCommand.getCurrency(), 
            TransactionStatus.SUCCESS, 
            "87654321", 
            100.0 + aCommand.getAmount(), 
            "USD");
    }
}
