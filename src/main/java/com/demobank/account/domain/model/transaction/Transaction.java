package com.demobank.account.domain.model.transaction;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Transaction {

    @Id
    private UUID transactionId;
    private String accountId;
    private Double amount;
    private String currencyCode;
    private TransactionStatus transactionStatus;
    private Double newBalance;
    private String newBalanceCurrencyCode;

    public Transaction(UUID transactionId, String accountId, Double amount, String currencyCode, TransactionStatus transactionStatus, Double newBalance, String newBalanceCurrencyCode) {
        super();

        this.setTransactionId(transactionId);
        this.setAccountId(accountId);
        this.setAmount(amount);
        this.setCurrencyCode(currencyCode);
        this.setStatus(transactionStatus);
        this.setNewBalance(newBalance);
        this.setNewBalanceCurrencyCode(newBalanceCurrencyCode);
    }

    public Transaction() {
        super();
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
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

    public TransactionStatus getStatus() {
        return transactionStatus;
    }

    public void setStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
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
