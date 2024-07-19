package com.demobank.account.port.adapter.controller.transaction;

public class TransactionRequest {
    private Double amount;
    private String currencyCode;

    public TransactionRequest(Double amount, String currencyCode) {
        super();

        this.setAmount(amount);
        this.setCurrencyCode(currencyCode);
    }

    public TransactionRequest() {
        super();
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}