package com.demobank.account.domain.model.account;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {

    @Id
    private String accountId;
    private Double balance;
    private String balanceCurrencyCode;
    public Account(String accountId, Double balance, String balanceCurrencyCode) {
        super();
        this.accountId = accountId;
        this.balance = balance;
        this.balanceCurrencyCode = balanceCurrencyCode;
    }
    public Account() {
        super();
    }
    public String getAccountId() {
        return accountId;
    }
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
        this.balance = balance;
    }
    public String getBalanceCurrencyCode() {
        return balanceCurrencyCode;
    }
    public void setBalanceCurrencyCode(String balanceCurrencyCode) {
        this.balanceCurrencyCode = balanceCurrencyCode;
    }
    public void newBalance(Double balance) {
        this.setBalance(balance);
    }
}
