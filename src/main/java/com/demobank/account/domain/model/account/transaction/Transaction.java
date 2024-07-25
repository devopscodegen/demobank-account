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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name="transactions")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@ToString
@org.jmolecules.ddd.annotation.Entity
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
    private TransactionType transactionType;
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

    public Transaction(TransactionId transactionId, AccountId accountId, TransactionType transactionType, Money amount, TransactionStatus transactionStatus, Money newBalance) {
        super();

        this.setTransactionId(transactionId);
        this.setAccountId(accountId);
        this.setTransactionType(transactionType);
        this.setAmount(amount);
        this.setTransactionStatus(transactionStatus);
        this.setNewBalance(newBalance);
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
