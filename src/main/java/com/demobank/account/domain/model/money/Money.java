package com.demobank.account.domain.model.money;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import org.springframework.util.Assert;

import com.demobank.account.domain.model.currency.CurrencyCode;

import jakarta.persistence.Embeddable;

@Embeddable
public class Money implements Serializable, Comparable<Money>{

    private static final long serialVersionUID = 1L;
    private BigDecimal amount;
    private CurrencyCode currencyCode;
    public Money(BigDecimal amount, CurrencyCode currencyCode) {
        this.setAmount(amount);
        this.setCurrencyCode(currencyCode);
    }
    @SuppressWarnings("unused")
    private Money() {
    }
    public BigDecimal getAmount() {
        return amount;
    }
    private void setAmount(BigDecimal amount) {
        Objects.requireNonNull(amount, "amount must not be empty");
        this.amount = amount;
    }
    public CurrencyCode getCurrencyCode() {
        return currencyCode;
    }
    private void setCurrencyCode(CurrencyCode currencyCode) {
        this.currencyCode = currencyCode;
    }
    public Money add(Money money) {
        Assert.isTrue(this.getCurrencyCode().equals(money.getCurrencyCode()), "money objects must have same currency code");
        return new Money(
            this.getAmount().add(money.getAmount()),
            this.getCurrencyCode());
    }
    public Money subtract(Money money) {
        Assert.isTrue(this.getCurrencyCode().equals(money.getCurrencyCode()), "money objects must have same currency code");
        return new Money(
            this.getAmount().subtract(money.getAmount()),
            this.getCurrencyCode());
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((amount == null) ? 0 : amount.hashCode());
        result = prime * result + ((currencyCode == null) ? 0 : currencyCode.hashCode());
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
        Money other = (Money) obj;
        if (amount == null) {
            if (other.amount != null)
                return false;
        } else if (!amount.equals(other.amount))
            return false;
        if (currencyCode != other.currencyCode)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Money [amount=" + amount + ", currencyCode=" + currencyCode + "]";
    }
    @Override
    public int compareTo(Money Money) {
        return this.getAmount().compareTo(Money.getAmount());
    }
}
