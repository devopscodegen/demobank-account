package com.demobank.account.application.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demobank.account.domain.model.account.Transaction;
import com.demobank.account.domain.model.account.TransactionStatus;
import com.demobank.account.domain.model.fees.FeesService;
import com.demobank.account.domain.model.transaction.TransactionType;

@Service
public class AccountApplicationService {

    @Autowired
    private FeesService feesService;

    public Transaction withdraw(WithdrawCommand aCommand) {
        return new Transaction(
            aCommand.getAccountId(), 
            aCommand.getAmount(), 
            aCommand.getCurrency(), 
            TransactionStatus.SUCCESS, 
            "12345678", 
            100.0 - aCommand.getAmount() - this.feesService.calculateTransactionFees(TransactionType.WITHDRAW, aCommand.getAmount(), aCommand.getCurrency()).getFees(),
            "USD");
    }

    public Transaction deposit(DepositCommand aCommand) {
        return new Transaction(
            aCommand.getAccountId(), 
            aCommand.getAmount(), 
            aCommand.getCurrency(), 
            TransactionStatus.SUCCESS, 
            "87654321", 
            100.0 + aCommand.getAmount() - this.feesService.calculateTransactionFees(TransactionType.DEPOSIT, aCommand.getAmount(), aCommand.getCurrency()).getFees(),
            "USD");
    }
}
