package com.demobank.account.domain.model.account;

import java.util.Set;

import org.jmolecules.ddd.annotation.AggregateRoot;

import com.demobank.account.domain.model.account.transaction.Transaction;
import com.demobank.account.domain.model.account.transaction.TransactionId;
import com.demobank.account.domain.model.account.transaction.TransactionStatus;
import com.demobank.account.domain.model.common.BaseAggregateRoot;
import com.demobank.account.domain.model.money.Money;

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
    @Embedded
    private Money balance;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Transaction> transactions;
    public Account(AccountId accountId, Money balance) {
        super();
        this.setAccountId(accountId);
        this.setBalance(balance);
        registerEvent(new AccountOpened(this));
    }
    public Transaction withdrawAmount(Money amount, Money amountConvertedToAccountBalanceCurrencyCode, Money transactionFees) {

        this.setBalance(this.getBalance().subtract(amountConvertedToAccountBalanceCurrencyCode).subtract(transactionFees));

        Transaction transaction = new Transaction(
            new TransactionId(),
            this.getAccountId(), 
            amount,
            TransactionStatus.SUCCESS,
            this.getBalance());

        this.getTransactions().add(transaction);

        registerEvent(new AmountWithdrawnFromAccount(transaction));

        return transaction;
    }
    public Transaction depositAmount(Money amount, Money amountConvertedToAccountBalanceCurrencyCode, Money transactionFees) {

        this.setBalance(this.getBalance().add(amountConvertedToAccountBalanceCurrencyCode).subtract(transactionFees));

        Transaction transaction = new Transaction(
            new TransactionId(),
            this.getAccountId(), 
            amount,
            TransactionStatus.SUCCESS,
            this.getBalance());

        this.getTransactions().add(transaction);

        registerEvent(new AmountDepositedToAccount(transaction));

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
