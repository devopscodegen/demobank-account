package com.example.bank.account.domain.model.account;

import java.math.BigDecimal;
import java.util.Set;

import org.jmolecules.ddd.annotation.AggregateRoot;

import com.example.bank.account.domain.model.account.transaction.Transaction;
import com.example.bank.account.domain.model.account.transaction.TransactionId;
import com.example.bank.account.domain.model.account.transaction.TransactionStatus;
import com.example.bank.account.domain.model.account.transaction.TransactionType;
import com.example.bank.account.domain.model.common.BaseAggregateRoot;
import com.example.bank.account.domain.model.currency.CurrencyCode;
import com.example.bank.account.domain.model.money.Money;

import jakarta.annotation.Nullable;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name="accounts")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@ToString
@AggregateRoot
public class Account extends BaseAggregateRoot<Account, AccountId> {

    @EmbeddedId
    @AttributeOverrides({
        @AttributeOverride(
            name="id", 
            column=@jakarta.persistence.Column(name="account_id"))
    })
    @EqualsAndHashCode.Include
    private AccountId accountId;
    private AccountType accountType;
    @Embedded
    private Money balance;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Transaction> transactions;
    public Account(AccountId accountId, AccountType accountType, CurrencyCode balanceCurrencyCode) {
        this(accountId, accountType,
            new Money(BigDecimal.ZERO, balanceCurrencyCode));
    }
    public Account(AccountId accountId, AccountType accountType, Money balance) {
        super();
        this.setAccountId(accountId);
        this.setAccountType(accountType);
        this.setBalance(balance);
        registerEvent(new AccountOpened(this));
    }
    public Transaction debitAmount(Money amount, Money amountConvertedToAccountBalanceCurrencyCode, Money transactionFees) {

        this.setBalance(this.getBalance().subtract(amountConvertedToAccountBalanceCurrencyCode).subtract(transactionFees));

        Transaction transaction = new Transaction(
            new TransactionId(),
            this.getAccountId(), 
            TransactionType.DEBIT,
            amount,
            TransactionStatus.SUCCESS,
            this.getBalance());

        this.getTransactions().add(transaction);

        registerEvent(new AmountDebitedFromAccount(transaction));

        return transaction;
    }
    public Transaction creditAmount(Money amount, Money amountConvertedToAccountBalanceCurrencyCode, Money transactionFees) {

        this.setBalance(this.getBalance().add(amountConvertedToAccountBalanceCurrencyCode).subtract(transactionFees));

        Transaction transaction = new Transaction(
            new TransactionId(),
            this.getAccountId(), 
            TransactionType.CREDIT,
            amount,
            TransactionStatus.SUCCESS,
            this.getBalance());

        this.getTransactions().add(transaction);

        registerEvent(new AmountCreditedToAccount(transaction));

        return transaction;
    }
    @Nullable
	@Override
	public AccountId getId() {
		return this.getAccountId();
	}
	@Transient
	@Override
	public boolean isNew() {
		return null == this.getId();
	}
}
