package com.demobank.account.port.adapter.controller.account;

public class OpenAccountRequest {
    private String accountId;
    private String balanceCurrencyCode;

    public OpenAccountRequest(String accountId, String balanceCurrencyCode) {
        super();

        this.setAccountId(accountId);
        this.setBalanceCurrencyCode(balanceCurrencyCode);
    }

    public OpenAccountRequest() {
        super();
    }

    public String getAccoundId() {
        return this.accountId;
    }

    private void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getBalanceCurrencyCode() {
        return this.balanceCurrencyCode;
    }

    private void setBalanceCurrencyCode(String balanceCurrencyCode) {
        this.balanceCurrencyCode = balanceCurrencyCode;
    }
}