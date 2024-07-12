package com.demobank.account.application;

public class WithdrawCommand {

    private String accountId;
    private Double amount;
    private String currency;

    public WithdrawCommand(String accountId, Double amount, String currency) {
        super();

        setAccountId(accountId);
        setAmount(amount);
        setCurrency(currency);
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
