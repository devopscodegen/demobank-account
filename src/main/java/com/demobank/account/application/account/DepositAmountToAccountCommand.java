package com.demobank.account.application.account;

import java.math.BigDecimal;
import java.math.BigInteger;

public class DepositAmountToAccountCommand {

    private BigInteger accountId;
    private BigDecimal amount;
    private String currencyCode;

    public DepositAmountToAccountCommand(BigInteger accountId, BigDecimal amount, String currencyCode) {
        super();

        this.setAccountId(accountId);
        this.setAmount(amount);
        this.setCurrencyCode(currencyCode);
    }

    public DepositAmountToAccountCommand() {
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
