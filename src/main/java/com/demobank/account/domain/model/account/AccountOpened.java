package com.demobank.account.domain.model.account;

import java.util.Date;

import org.jmolecules.event.annotation.DomainEvent;

import com.demobank.account.domain.model.common.BaseDomainEvent;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
@DomainEvent
public class AccountOpened extends BaseDomainEvent {
    private Account account;

    public AccountOpened(Account account) {
        super();
        this.setAccount(account);
        this.setEventVersion(1);
        this.setOccurredOn(new Date());
        this.setEventType(this.getClass().getName());
    }
}
