package com.demobank.account.application.account;

public class OpenAccountCommand {
    private String accountId;
    private String balanceCurrencyCode;
    public OpenAccountCommand(String accountId, String balanceCurrencyCode) {
        this.accountId = accountId;
        this.balanceCurrencyCode = balanceCurrencyCode;
    }
    public String getAccountId() {
        return accountId;
    }
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    public String getBalanceCurrencyCode() {
        return balanceCurrencyCode;
    }
    public void setBalanceCurrencyCode(String balanceCurrencyCode) {
        this.balanceCurrencyCode = balanceCurrencyCode;
    }
}
