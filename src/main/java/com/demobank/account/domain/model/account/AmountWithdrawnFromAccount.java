package com.demobank.account.domain.model.account;

import java.util.Date;

import org.jmolecules.event.types.DomainEvent;

import com.demobank.account.domain.model.account.transaction.Transaction;
import com.demobank.account.domain.model.common.BaseDomainEvent;

public class AmountWithdrawnFromAccount extends BaseDomainEvent implements DomainEvent{
    private Transaction transaction;

    public AmountWithdrawnFromAccount() {
        super();
    }

    public Transaction getTransaction() {
        return this.transaction;
    }

    private void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public AmountWithdrawnFromAccount(Transaction transaction) {
        super();
        this.setTransaction(transaction);
        this.setEventVersion(1);
        this.setOccurredOn(new Date());
        this.setEventType(this.getClass().getName());
    }
}
