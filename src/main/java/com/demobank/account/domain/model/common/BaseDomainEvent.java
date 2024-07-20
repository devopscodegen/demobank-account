package com.demobank.account.domain.model.common;

import java.util.Date;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseDomainEvent implements DomainEvent{
    
    private int eventVersion;
    private Date occurredOn;
    private String eventType;

    public int getEventVersion() {
        return this.eventVersion;
    }

    protected void setEventVersion(int eventVersion) {
        this.eventVersion = eventVersion;
    }

    public Date getOccurredOn() {
        return this.occurredOn;
    }

    protected void setOccurredOn(Date occurredOn) {
        this.occurredOn = occurredOn;
    }

    public String getEventType() {
        return eventType;
    }

    protected void setEventType(String eventType) {
        this.eventType = eventType;
    }
}
