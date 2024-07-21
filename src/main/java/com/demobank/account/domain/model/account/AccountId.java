package com.demobank.account.domain.model.account;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

import org.jmolecules.ddd.annotation.ValueObject;
import org.jmolecules.ddd.types.Identifier;
import org.springframework.util.Assert;

import com.demobank.account.domain.model.common.BaseValueObject;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@ValueObject
public class AccountId implements Serializable, Comparable<AccountId>, Identifier, BaseValueObject{

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
    @Override
    public int compareTo(AccountId AccountId) {
        return this.getId().compareTo(AccountId.getId());
    }
}
