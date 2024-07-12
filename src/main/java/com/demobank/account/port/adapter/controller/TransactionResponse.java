package com.demobank.account.port.adapter.controller;

public class TransactionResponse {
    private String status;
    private String transactionId;
    private double newBalance;
    private String newBalanceCurrency;

    public TransactionResponse() {}

    public TransactionResponse(String status, String transactionId, double newBalance, String newBalanceCurrency) {
        setStatus(status);
        setTransactionId(transactionId);
        setNewBalance(newBalance);
        setNewBalanceCurrency(newBalanceCurrency);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public double getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(double newBalance) {
        this.newBalance = newBalance;
    }

    public String getNewBalanceCurrency() {
        return newBalanceCurrency;
    }

    public void setNewBalanceCurrency(String newBalanceCurrency) {
        this.newBalanceCurrency = newBalanceCurrency;
    }
}