package com.demobank.account.domain.model.account;

import java.util.Date;

import org.jmolecules.event.types.DomainEvent;

import com.demobank.account.domain.model.common.BaseDomainEvent;

public class AccountOpened extends BaseDomainEvent implements DomainEvent {
    private Account account;

    public AccountOpened() {
        super();
    }

    public Account getAccount() {
        return this.account;
    }

    private void setAccount(Account account) {
        this.account = account;
    }

    public AccountOpened(Account account) {
        super();
        this.setAccount(account);
        this.setEventVersion(1);
        this.setOccurredOn(new Date());
        this.setEventType(this.getClass().getName());
    }
}
