package com.demobank.account.port.adapter.controller.account.transaction;

import java.math.BigDecimal;
import java.util.UUID;

public class TransactionResponse {
    private String status;
    private UUID transactionId;
    private BigDecimal newBalance;
    private String newBalanceCurrencyCode;

    public TransactionResponse() {}

    public TransactionResponse(String status, UUID transactionId, BigDecimal newBalance, String newBalanceCurrencyCode) {
        this.setStatus(status);
        this.setTransactionId(transactionId);
        this.setNewBalance(newBalance);
        this.setNewBalanceCurrencyCode(newBalanceCurrencyCode);
    }

    public String getStatus() {
        return status;
    }

    private void setStatus(String status) {
        this.status = status;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    private void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public BigDecimal getNewBalance() {
        return newBalance;
    }

    private void setNewBalance(BigDecimal newBalance) {
        this.newBalance = newBalance;
    }

    public String getNewBalanceCurrencyCode() {
        return newBalanceCurrencyCode;
    }

    private void setNewBalanceCurrencyCode(String newBalanceCurrencyCode) {
        this.newBalanceCurrencyCode = newBalanceCurrencyCode;
    }
}