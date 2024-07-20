package com.demobank.account.domain.model.account.transaction;

import com.demobank.account.domain.model.account.AccountId;
import com.demobank.account.domain.model.common.BaseEntity;
import com.demobank.account.domain.model.money.Money;

import jakarta.annotation.Nullable;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="transactions")
public class Transaction extends BaseEntity<TransactionId> {

    @EmbeddedId
    @AttributeOverrides({
        @AttributeOverride(
            name="id", 
            column=@jakarta.persistence.Column(name="transaction_id"))
    })
    private TransactionId transactionId;
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(
            name="id", 
            column=@jakarta.persistence.Column(name="account_id"))
    })
    private AccountId accountId;
    @Embedded
    private Money amount;
    private TransactionStatus transactionStatus;
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(
            name="amount", 
            column=@jakarta.persistence.Column(name="new_balance")),
        @AttributeOverride(
            name="currencyCode", 
            column=@jakarta.persistence.Column(name="new_balance_currency_code"))
    })
    private Money newBalance;

    public Transaction(TransactionId transactionId, AccountId accountId, Money amount, TransactionStatus transactionStatus, Money newBalance) {
        super();

        this.setTransactionId(transactionId);
        this.setAccountId(accountId);
        this.setAmount(amount);
        this.setStatus(transactionStatus);
        this.setNewBalance(newBalance);
    }

    public Transaction() {
        super();
    }

    public TransactionId getTransactionId() {
        return transactionId;
    }

    private void setTransactionId(TransactionId transactionId) {
        this.transactionId = transactionId;
    }

    public AccountId getAccountId() {
        return accountId;
    }

    private void setAccountId(AccountId accountId) {
        this.accountId = accountId;
    }

    public Money getAmount() {
        return amount;
    }

    private void setAmount(Money amount) {
        this.amount = amount;
    }

    public TransactionStatus getStatus() {
        return transactionStatus;
    }

    private void setStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public Money getNewBalance() {
        return newBalance;
    }

    private void setNewBalance(Money newBalance) {
        this.newBalance = newBalance;
    }

    @Nullable
	@Override
	public TransactionId getId() {
		return this.getTransactionId();
	}
	@Transient
	@Override
	public boolean isNew() {
		return null == getId();
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((transactionId == null) ? 0 : transactionId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Transaction other = (Transaction) obj;
        if (transactionId == null) {
            if (other.transactionId != null)
                return false;
        } else if (!transactionId.equals(other.transactionId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Transaction [transactionId=" + transactionId + ", accountId=" + accountId + ", amount=" + amount
                + ", transactionStatus=" + transactionStatus + ", newBalance=" + newBalance + "]";
    }
}
