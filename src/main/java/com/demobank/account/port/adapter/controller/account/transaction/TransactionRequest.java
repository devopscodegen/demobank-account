package com.demobank.account.port.adapter.controller.account.transaction;

import java.math.BigDecimal;

public class TransactionRequest {
    private BigDecimal amount;
    private String currencyCode;

    public TransactionRequest(BigDecimal amount, String currencyCode) {
        super();

        this.setAmount(amount);
        this.setCurrencyCode(currencyCode);
    }

    public TransactionRequest() {
        super();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    private void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    private void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}