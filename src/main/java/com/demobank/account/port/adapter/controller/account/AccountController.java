package com.demobank.account.port.adapter.controller.account;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demobank.account.application.account.AccountApplicationService;
import com.demobank.account.application.account.DepositAmountToAccountCommand;
import com.demobank.account.application.account.OpenAccountCommand;
import com.demobank.account.application.account.WithdrawAmountFromAccountCommand;
import com.demobank.account.domain.model.account.transaction.Transaction;
import com.demobank.account.port.adapter.controller.account.transaction.TransactionRequest;
import com.demobank.account.port.adapter.controller.account.transaction.TransactionResponse;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {
    @Autowired
    private AccountApplicationService accountApplicationService;

    @PostMapping("/{accountId}")
    public OpenAccountResponse openAccount(@PathVariable BigInteger accountId, @RequestBody OpenAccountRequest request) {
        this.accountApplicationService.openAccount(
            new OpenAccountCommand(
                accountId,
                request.getBalanceCurrencyCode()));
        
        return new OpenAccountResponse(
            "SUCCESS");
    }

    @PostMapping("/{accountId}/withdraw")
    public TransactionResponse withdrawAmountFromAccount(@PathVariable BigInteger accountId, @RequestBody TransactionRequest request) {
        Transaction transaction = this.accountApplicationService.withdrawAmountFromAccount(
            new WithdrawAmountFromAccountCommand(
                accountId,
                request.getAmount(), 
                request.getCurrencyCode()));
                
        return new TransactionResponse(
            transaction.getTransactionStatus().toString(), 
            transaction.getTransactionId().getId(),
            transaction.getNewBalance().getAmount(), 
            transaction.getNewBalance().getCurrencyCode().toString()
        );
    }

    @PostMapping("/{accountId}/deposit")
    public TransactionResponse depositAmountToAccount(@PathVariable BigInteger accountId, @RequestBody TransactionRequest request) {
        Transaction transaction = this.accountApplicationService.depositAmountToAccount(
            new DepositAmountToAccountCommand(
                accountId,
                request.getAmount(), 
                request.getCurrencyCode()));

        return new TransactionResponse(
            transaction.getTransactionStatus().toString(), 
            transaction.getTransactionId().getId(),
            transaction.getNewBalance().getAmount(), 
            transaction.getNewBalance().getCurrencyCode().toString()
        );
    }
}