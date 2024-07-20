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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name="transactions")
@Getter
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@ToString
public class Transaction extends BaseEntity<TransactionId> {

    @EmbeddedId
    @AttributeOverrides({
        @AttributeOverride(
            name="id", 
            column=@jakarta.persistence.Column(name="transaction_id"))
    })
    @EqualsAndHashCode.Include
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

    private void setTransactionId(TransactionId transactionId) {
        this.transactionId = transactionId;
    }

    private void setAccountId(AccountId accountId) {
        this.accountId = accountId;
    }

    private void setAmount(Money amount) {
        this.amount = amount;
    }

    private void setStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
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
}
