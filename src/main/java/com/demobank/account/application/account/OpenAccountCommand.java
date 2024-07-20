package com.demobank.account.application.account;

import java.math.BigInteger;

public class OpenAccountCommand {
    private BigInteger accountId;
    private String balanceCurrencyCode;
    public OpenAccountCommand(BigInteger accountId, String balanceCurrencyCode) {
        this.setAccountId(accountId);
        this.setBalanceCurrencyCode(balanceCurrencyCode);
    }
    public BigInteger getAccountId() {
        return accountId;
    }
    private void setAccountId(BigInteger accountId) {
        this.accountId = accountId;
    }
    public String getBalanceCurrencyCode() {
        return balanceCurrencyCode;
    }
    private void setBalanceCurrencyCode(String balanceCurrencyCode) {
        this.balanceCurrencyCode = balanceCurrencyCode;
    }
}
