package com.demobank.account.port.adapter.controller.account;

import org.aspectj.apache.bcel.classfile.Module.Open;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demobank.account.application.account.AccountApplicationService;
import com.demobank.account.application.account.DepositCommand;
import com.demobank.account.application.account.OpenAccountCommand;
import com.demobank.account.application.account.WithdrawCommand;
import com.demobank.account.domain.model.account.Account;
import com.demobank.account.domain.model.transaction.Transaction;
import com.demobank.account.port.adapter.controller.transaction.TransactionRequest;
import com.demobank.account.port.adapter.controller.transaction.TransactionResponse;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {
    @Autowired
    private AccountApplicationService accountApplicationService;

    @PostMapping("/{accountId}")
    public OpenAccountResponse open(@PathVariable String accountId, @RequestBody OpenAccountRequest request) {
        this.accountApplicationService.open(
            new OpenAccountCommand(
                accountId,
                request.getBalanceCurrencyCode()));
        
        return new OpenAccountResponse(
            "SUCCESS");
    }

    @PostMapping("/{accountId}/withdraw")
    public TransactionResponse withdraw(@PathVariable String accountId, @RequestBody TransactionRequest request) {
        Transaction transaction = this.accountApplicationService.withdraw(
            new WithdrawCommand(
                accountId,
                request.getAmount(), 
                request.getCurrencyCode()));
                
        return new TransactionResponse(
            transaction.getStatus().toString(), 
            transaction.getTransactionId(),
            transaction.getNewBalance(), 
            transaction.getNewBalanceCurrencyCode());
    }

    @PostMapping("/{accountId}/deposit")
    public TransactionResponse deposit(@PathVariable String accountId, @RequestBody TransactionRequest request) {
        Transaction transaction = this.accountApplicationService.deposit(
            new DepositCommand(
                accountId,
                request.getAmount(), 
                request.getCurrencyCode()));

        return new TransactionResponse(
            transaction.getStatus().toString(), 
            transaction.getTransactionId(),
            transaction.getNewBalance(), 
            transaction.getNewBalanceCurrencyCode());
    }
}