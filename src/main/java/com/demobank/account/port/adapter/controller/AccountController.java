package com.demobank.account.port.adapter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demobank.account.application.AccountApplicationService;
import com.demobank.account.application.DepositCommand;
import com.demobank.account.application.WithdrawCommand;
import com.demobank.account.domain.model.Transaction;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountApplicationService accountApplicationService;

    @PostMapping("/{accountId}/withdraw")
    public TransactionResponse withdraw(@PathVariable String accountId, @RequestBody TransactionRequest request) {
        Transaction transaction = accountApplicationService.withdraw(new WithdrawCommand(accountId,
                request.getAmount(), request.getCurrency()));
        return new TransactionResponse(transaction.getStatus().name(), transaction.getTransactionId(),
                transaction.getNewBalance(), transaction.getNewBalanceCurrency());
    }

    @PostMapping("/{accountId}/deposit")
    public TransactionResponse deposit(@PathVariable String accountId, @RequestBody TransactionRequest request) {
        Transaction transaction = accountApplicationService.deposit(new DepositCommand(accountId,
                request.getAmount(), request.getCurrency()));
        return new TransactionResponse(transaction.getStatus().name(), transaction.getTransactionId(),
                transaction.getNewBalance(), transaction.getNewBalanceCurrency());
    }
}