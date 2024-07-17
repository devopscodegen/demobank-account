package com.demobank.account.domain.model.account;

public class Transaction {
    private String accountId;
    private Double amount;
    private String currency;
    private TransactionStatus transactionStatus;
    private String transactionId;
    private double newBalance;
    private String newBalanceCurrency;

    public Transaction(String accountId, Double amount, String currency, TransactionStatus transactionStatus, String transactionId, double newBalance, String newBalanceCurrency) {
        super();

        this.setAccountId(accountId);
        this.setAmount(amount);
        this.setCurrency(currency);
        this.setStatus(transactionStatus);
        this.setTransactionId(transactionId);
        this.setNewBalance(newBalance);
        this.setNewBalanceCurrency(newBalanceCurrency);
    }

    public Transaction() {
        super();
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
