package com.demobank.account.domain.model.account;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

import org.jmolecules.ddd.types.Identifier;
import org.springframework.util.Assert;

import jakarta.persistence.Embeddable;

@Embeddable
public class AccountId implements Serializable, Comparable<AccountId>, Identifier{

    private static final long serialVersionUID = 1L;
    private BigInteger id;
    public BigInteger getId() {
        return id;
    }
    private void setId(BigInteger id) {
        Objects.requireNonNull(id, "Account Id must not be empty");
        Assert.isTrue(id.compareTo(BigInteger.ZERO) > 0, "Account Id must be greater than zero");
        this.id = id;
    }
    public AccountId(BigInteger id) {
        super();
        this.setId(id);
    }
    @SuppressWarnings("unused")
    private AccountId() {
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
        AccountId other = (AccountId) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "AccountId [id=" + id + "]";
    }
    @Override
    public int compareTo(AccountId AccountId) {
        return this.getId().compareTo(AccountId.getId());
    }
}
