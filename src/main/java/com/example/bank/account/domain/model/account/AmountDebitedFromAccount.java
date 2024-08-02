package com.example.bank.account.domain.model.account;

import java.util.Date;

import org.jmolecules.event.annotation.DomainEvent;

import com.example.bank.account.domain.model.account.transaction.Transaction;
import com.example.bank.account.domain.model.common.BaseDomainEvent;

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
public class AmountDebitedFromAccount extends BaseDomainEvent {
    private Transaction transaction;

    public AmountDebitedFromAccount(Transaction transaction) {
        super();
        this.setTransaction(transaction);
        this.setEventVersion(1);
        this.setOccurredOn(new Date());
        this.setEventType(this.getClass().getName());
    }
}
