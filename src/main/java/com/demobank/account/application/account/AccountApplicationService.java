package com.demobank.account.application.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demobank.account.domain.model.account.Account;
import com.demobank.account.domain.model.account.AccountRepository;
import com.demobank.account.domain.model.currency.CurrencyService;
import com.demobank.account.domain.model.fees.FeesService;
import com.demobank.account.domain.model.transaction.Transaction;
import com.demobank.account.domain.model.transaction.TransactionIdService;
import com.demobank.account.domain.model.transaction.TransactionRepository;
import com.demobank.account.domain.model.transaction.TransactionStatus;
import com.demobank.account.domain.model.transaction.TransactionType;

@Service
public class AccountApplicationService {

    @Autowired
    private FeesService feesService;

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionIdService transactionIdService;

    public Account open(OpenAccountCommand aCommand) {
        Account account = new Account(
            aCommand.getAccountId(), 
            0.0, 
            aCommand.getBalanceCurrencyCode());
        
        account = this.accountRepository.save(account);

        return account;
    }
    @Transactional
    public Transaction withdraw(WithdrawCommand aCommand) {

        Account account = this.accountRepository.findById(aCommand.getAccountId()).get();

        Transaction transaction = new Transaction(
            transactionIdService.nextIdentity(),
            account.getAccountId(), 
            aCommand.getAmount(), 
            aCommand.getCurrencyCode(), 
            TransactionStatus.SUCCESS,  
            account.getBalance() - this.currencyService.convertAmount(aCommand.getCurrencyCode(),aCommand.getAmount(),account.getBalanceCurrencyCode()).getConvertedAmount() - this.feesService.calculateTransactionFees(TransactionType.WITHDRAW, aCommand.getAmount(), aCommand.getCurrencyCode()).getFees(),
            "USD");

        account.newBalance(transaction.getNewBalance());
        
        transaction = this.transactionRepository.save(transaction);

        account = this.accountRepository.save(account);

        return transaction;
    }

    @Transactional
    public Transaction deposit(DepositCommand aCommand) {
        Account account = this.accountRepository.findById(aCommand.getAccountId()).get();

        Transaction transaction = new Transaction(
            transactionIdService.nextIdentity(),
            account.getAccountId(), 
            aCommand.getAmount(), 
            aCommand.getCurrencyCode(), 
            TransactionStatus.SUCCESS,  
            account.getBalance() + this.currencyService.convertAmount(aCommand.getCurrencyCode(),aCommand.getAmount(),account.getBalanceCurrencyCode()).getConvertedAmount() - this.feesService.calculateTransactionFees(TransactionType.WITHDRAW, aCommand.getAmount(), aCommand.getCurrencyCode()).getFees(),
            "USD");

        account.newBalance(transaction.getNewBalance());
        
        transaction = this.transactionRepository.save(transaction);

        account = this.accountRepository.save(account);

        return transaction;
    }
}
