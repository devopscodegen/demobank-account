package com.demobank.account.domain.model.currency;

import com.demobank.account.domain.model.money.Money;

public class ConvertedAmount {
    private Money amount;
    private CurrencyCode toCurrencyCode;
    private CurrencyStatus currencyStatus;
    private Money convertedAmount;

    public ConvertedAmount(Money amount, CurrencyCode toCurrencyCode, CurrencyStatus currencyStatus, Money convertedAmount) {
        super();

        this.setAmount(amount);
        this.setToCurrencyCode(toCurrencyCode);
        this.setStatus(currencyStatus);
        this.setConvertedAmount(convertedAmount);
    }

    public ConvertedAmount() {
        super();
    }

    public Money getAmount() {
        return amount;
    }

    private void setAmount(Money amount) {
        this.amount = amount;
    }

    public CurrencyCode getToCurrencyCode() {
        return toCurrencyCode;
    }

    private void setToCurrencyCode(CurrencyCode toCurrencyCode) {
        this.toCurrencyCode = toCurrencyCode;
    }

    public CurrencyStatus getStatus() {
        return currencyStatus;
    }

    private void setStatus(CurrencyStatus currencyStatus) {
        this.currencyStatus = currencyStatus;
    }

    public Money getConvertedAmount() {
        return convertedAmount;
    }

    private void setConvertedAmount(Money convertedAmount) {
        this.convertedAmount = convertedAmount;
    }
}
