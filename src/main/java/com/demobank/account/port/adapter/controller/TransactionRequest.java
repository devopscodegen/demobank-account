package com.demobank.account.port.adapter.controller;

public class TransactionRequest {
    private Double amount;
    private String currency;

    public TransactionRequest(Double amount, String currency) {
        super();

        setAmount(amount);
        setCurrency(currency);
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}