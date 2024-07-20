package com.demobank.account.application.account;

import java.math.BigDecimal;
import java.math.BigInteger;

public class WithdrawAmountFromAccountCommand {

    private BigInteger accountId;
    private BigDecimal amount;
    private String currencyCode;

    public WithdrawAmountFromAccountCommand(BigInteger accountId, BigDecimal amount, String currencyCode) {
        super();

        this.setAccountId(accountId);
        this.setAmount(amount);
        this.setCurrencyCode(currencyCode);
    }

    public WithdrawAmountFromAccountCommand() {
        super();
    }

    public BigInteger getAccountId() {
        return accountId;
    }

    private void setAccountId(BigInteger accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    private void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    private void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
