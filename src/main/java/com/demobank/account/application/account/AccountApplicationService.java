package com.demobank.account.application.account;

import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;

import com.demobank.account.domain.model.account.Account;
import com.demobank.account.domain.model.account.AccountId;
import com.demobank.account.domain.model.account.AccountRepository;
import com.demobank.account.domain.model.account.transaction.Transaction;
import com.demobank.account.domain.model.account.transaction.TransactionType;
import com.demobank.account.domain.model.currency.CurrencyCode;
import com.demobank.account.domain.model.currency.CurrencyService;
import com.demobank.account.domain.model.fees.FeesService;
import com.demobank.account.domain.model.money.Money;

@Service
@Application
public class AccountApplicationService {

    @Autowired
    private FeesService feesService;

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private AccountRepository accountRepository;

    public Account openAccount(OpenAccountCommand openAccountCommand) {
        Account account = new Account(
            new AccountId(openAccountCommand.getAccountId()),
            new Money(new BigDecimal(0), CurrencyCode.valueOf(openAccountCommand.getBalanceCurrencyCode()))
        );
        
        account = this.accountRepository.save(account);

        return account;
    }
    @Transactional
    public Transaction withdrawAmountFromAccount(WithdrawAmountFromAccountCommand withdrawAmountFromAccountCommand) {

        Account account = this.accountRepository.findById(new AccountId(withdrawAmountFromAccountCommand.getAccountId())).get();

        Money amount = new Money(
            withdrawAmountFromAccountCommand.getAmount(), 
            CurrencyCode.valueOf(withdrawAmountFromAccountCommand.getCurrencyCode())
        );
        Transaction transaction = account.withdrawAmount(
            amount,
            this.currencyService.convertAmount(
                amount,
                account.getBalance().getCurrencyCode()
            ).getConvertedAmount(),
            this.feesService.calculateTransactionFees(
                TransactionType.WITHDRAW, 
                amount).getFees()
        );

        account = this.accountRepository.save(account);

        return transaction;
    }

    @Transactional
    public Transaction depositAmountToAccount(DepositAmountToAccountCommand depositAmountFromAccountCommand) {
        Account account = this.accountRepository.findById(new AccountId(depositAmountFromAccountCommand.getAccountId())).get();

        Money amount = new Money(
            depositAmountFromAccountCommand.getAmount(), 
            CurrencyCode.valueOf(depositAmountFromAccountCommand.getCurrencyCode())
        );
        Transaction transaction = account.depositAmount(
            amount,
            this.currencyService.convertAmount(
                amount,
                account.getBalance().getCurrencyCode()
            ).getConvertedAmount(),
            this.feesService.calculateTransactionFees(
                TransactionType.DEPOSIT, 
                amount).getFees()
        );

        account = this.accountRepository.save(account);

        return transaction;
    }
}
