package com.demobank.account.port.adapter.controller.transaction;

import java.util.UUID;

public class TransactionResponse {
    private String status;
    private UUID transactionId;
    private Double newBalance;
    private String newBalanceCurrencyCode;

    public TransactionResponse() {}

    public TransactionResponse(String status, UUID transactionId, Double newBalance, String newBalanceCurrencyCode) {
        this.setStatus(status);
        this.setTransactionId(transactionId);
        this.setNewBalance(newBalance);
        this.setNewBalanceCurrencyCode(newBalanceCurrencyCode);
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

    public String getNewBalanceCurrencyCode() {
        return newBalanceCurrencyCode;
    }

    public void setNewBalanceCurrencyCode(String newBalanceCurrencyCode) {
        this.newBalanceCurrencyCode = newBalanceCurrencyCode;
    }
}