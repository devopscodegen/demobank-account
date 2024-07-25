package com.demobank.account.application.account;

import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;

import com.demobank.account.domain.model.account.Account;
import com.demobank.account.domain.model.account.AccountId;
import com.demobank.account.domain.model.account.AccountRepository;
import com.demobank.account.domain.model.account.AccountService;
import com.demobank.account.domain.model.account.AccountType;
import com.demobank.account.domain.model.account.transaction.Transaction;
import com.demobank.account.domain.model.account.transaction.TransactionType;
import com.demobank.account.domain.model.currency.CurrencyCode;
import com.demobank.account.domain.model.money.Money;

@Service
@Application
public class AccountApplicationService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    public Account openAccount(OpenAccountCommand openAccountCommand) {
        Account account = new Account(
            new AccountId(openAccountCommand.getAccountId()),
            AccountType.valueOf(openAccountCommand.getAccountType()),
            new Money(new BigDecimal(0), CurrencyCode.valueOf(openAccountCommand.getBalanceCurrencyCode()))
        );
        
        account = this.accountRepository.save(account);

        return account;
    }
    @Transactional
    public Transaction debitAmountFromAccount(DebitAmountFromAccountCommand debitAmountFromAccountCommand) {

        Account account = this.accountRepository.findById(new AccountId(debitAmountFromAccountCommand.getAccountId())).get();

        Money amount = new Money(
            debitAmountFromAccountCommand.getAmount(), 
            CurrencyCode.valueOf(debitAmountFromAccountCommand.getCurrencyCode())
        );
        Transaction transaction = account.debitAmount(
            amount,
            this.accountService.convertAmount(
                account, amount
            ),
            this.accountService.calculateTransactionFees(
                TransactionType.DEBIT, 
                amount)
        );

        this.accountRepository.save(account);

        return transaction;
    }

    @Transactional
    public Transaction creditAmountToAccount(CreditAmountToAccountCommand creditAmountFromAccountCommand) {
        Account account = this.accountRepository.findById(new AccountId(creditAmountFromAccountCommand.getAccountId())).get();

        Money amount = new Money(
            creditAmountFromAccountCommand.getAmount(), 
            CurrencyCode.valueOf(creditAmountFromAccountCommand.getCurrencyCode())
        );
        Transaction transaction = account.creditAmount(
            amount,
            this.accountService.convertAmount(
                account, amount
            ),
            this.accountService.calculateTransactionFees(
                TransactionType.CREDIT, 
                amount)
        );

        this.accountRepository.save(account);

        return transaction;
    }
}
