package com.demobank.account.domain.model.account.transaction;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.util.Assert;

import jakarta.persistence.Embeddable;

@Embeddable
public class TransactionId implements Serializable, Comparable<TransactionId>{

    private static final long serialVersionUID = 1L;
    private UUID id;
    public UUID getId() {
        return id;
    }
    private void setId(UUID id) {
        Assert.hasLength(id.toString(), "Transaction Id must not be empty");
        this.id = id;
    }
    public TransactionId(UUID id) {
        super();
        this.setId(id);
    }
    public TransactionId() {
        super();
        this.setId(UUID.randomUUID());
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        TransactionId other = (TransactionId) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "TransactionId [id=" + id + "]";
    }
    @Override
    public int compareTo(TransactionId TransactionId) {
        return this.getId().compareTo(TransactionId.getId());
    }
}
