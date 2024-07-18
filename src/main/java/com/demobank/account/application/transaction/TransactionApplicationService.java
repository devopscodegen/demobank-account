package com.demobank.account.application.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demobank.account.domain.model.currency.CurrencyService;
import com.demobank.account.domain.model.fees.FeesService;
import com.demobank.account.domain.model.transaction.Transaction;
import com.demobank.account.domain.model.transaction.TransactionIdService;
import com.demobank.account.domain.model.transaction.TransactionRepository;
import com.demobank.account.domain.model.transaction.TransactionStatus;
import com.demobank.account.domain.model.transaction.TransactionType;

@Service
public class TransactionApplicationService {

    @Autowired
    private FeesService feesService;

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionIdService transactionIdService;

    public Transaction withdraw(WithdrawCommand aCommand) {
        Transaction transaction = new Transaction(
            transactionIdService.nextIdentity(),
            aCommand.getAccountId(), 
            aCommand.getAmount(), 
            aCommand.getCurrency(), 
            TransactionStatus.SUCCESS,  
            100.0 - this.currencyService.convertAmount("USD",aCommand.getAmount(),"USD").getConvertedAmount() - this.feesService.calculateTransactionFees(TransactionType.WITHDRAW, aCommand.getAmount(), aCommand.getCurrency()).getFees(),
            "USD");

        transaction = this.transactionRepository.save(transaction);

        return transaction;
    }

    public Transaction deposit(DepositCommand aCommand) {
        Transaction transaction = new Transaction(
            transactionIdService.nextIdentity(),
            aCommand.getAccountId(), 
            aCommand.getAmount(), 
            aCommand.getCurrency(), 
            TransactionStatus.SUCCESS, 
            100.0 + this.currencyService.convertAmount("USD",aCommand.getAmount(),"USD").getConvertedAmount() - this.feesService.calculateTransactionFees(TransactionType.DEPOSIT, aCommand.getAmount(), aCommand.getCurrency()).getFees(),
            "USD");

        transaction = this.transactionRepository.save(transaction);

        return transaction;
    }
}
