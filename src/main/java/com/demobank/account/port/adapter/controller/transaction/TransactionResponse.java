package com.demobank.account.port.adapter.controller.transaction;

import java.util.UUID;

public class TransactionResponse {
    private String status;
    private UUID transactionId;
    private Double newBalance;
    private String newBalanceCurrency;

    public TransactionResponse() {}

    public TransactionResponse(String status, UUID transactionId, Double newBalance, String newBalanceCurrency) {
        this.setStatus(status);
        this.setTransactionId(transactionId);
        this.setNewBalance(newBalance);
        this.setNewBalanceCurrency(newBalanceCurrency);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public Double getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(Double newBalance) {
        this.newBalance = newBalance;
    }

    public String getNewBalanceCurrency() {
        return newBalanceCurrency;
    }

    public void setNewBalanceCurrency(String newBalanceCurrency) {
        this.newBalanceCurrency = newBalanceCurrency;
    }
}