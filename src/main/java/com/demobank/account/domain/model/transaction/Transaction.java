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
    private String currency;
    private TransactionStatus transactionStatus;
    private Double newBalance;
    private String newBalanceCurrency;

    public Transaction(UUID transactionId, String accountId, Double amount, String currency, TransactionStatus transactionStatus, Double newBalance, String newBalanceCurrency) {
        super();

        this.setTransactionId(transactionId);
        this.setAccountId(accountId);
        this.setAmount(amount);
        this.setCurrency(currency);
        this.setStatus(transactionStatus);
        this.setNewBalance(newBalance);
        this.setNewBalanceCurrency(newBalanceCurrency);
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    public String getNewBalanceCurrency() {
        return newBalanceCurrency;
    }

    public void setNewBalanceCurrency(String newBalanceCurrency) {
        this.newBalanceCurrency = newBalanceCurrency;
    }
}
