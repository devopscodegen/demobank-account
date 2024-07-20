package com.demobank.account.domain.model.account;

import java.util.Set;

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

@Entity
@Table(name="accounts")
public class Account extends BaseAggregateRoot<Account, AccountId> {

    @EmbeddedId
    @AttributeOverrides({
        @AttributeOverride(
            name="id", 
            column=@jakarta.persistence.Column(name="account_id"))
    })
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
    public Account() {
        super();
    }
    public AccountId getAccountId() {
        return accountId;
    }
    private void setAccountId(AccountId accountId) {
        this.accountId = accountId;
    }
    public Money getBalance() {
        return balance;
    }
    private void setBalance(Money balance) {
        this.balance = balance;
    }
    private Set<Transaction> getTransactions() {
        return this.transactions;
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
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((accountId == null) ? 0 : accountId.hashCode());
        return result;
    }
    @Nullable
	@Override
	public AccountId getId() {
		return this.getAccountId();
	}
	@Transient
	@Override
	public boolean isNew() {
		return null == getId();
	}
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Account other = (Account) obj;
        if (accountId == null) {
            if (other.accountId != null)
                return false;
        } else if (!accountId.equals(other.accountId))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Account [accountId=" + accountId + ", balance=" + balance + ", transactions=" + transactions + "]";
    }
}
