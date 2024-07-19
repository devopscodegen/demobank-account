package com.demobank.account.application.account;

public class WithdrawCommand {

    private String accountId;
    private Double amount;
    private String currencyCode;

    public WithdrawCommand(String accountId, Double amount, String currencyCode) {
        super();

        this.setAccountId(accountId);
        this.setAmount(amount);
        this.setCurrencyCode(currencyCode);
    }

    public WithdrawCommand() {
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

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
