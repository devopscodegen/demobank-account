package com.demobank.account.domain.model.account;

import java.util.Date;

import com.demobank.account.domain.model.account.transaction.Transaction;
import com.demobank.account.domain.model.common.BaseDomainEvent;

public class AmountDepositedToAccount extends BaseDomainEvent {
    private Transaction transaction;

    public AmountDepositedToAccount() {
        super();
    }

    public Transaction getTransaction() {
        return this.transaction;
    }

    private void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public AmountDepositedToAccount(Transaction transaction) {
        super();
        this.setTransaction(transaction);
        this.setEventVersion(1);
        this.setOccurredOn(new Date());
        this.setEventType(this.getClass().getName());
    }
}
