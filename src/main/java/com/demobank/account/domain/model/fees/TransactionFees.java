package com.demobank.account.domain.model.fees;

import com.demobank.account.domain.model.transaction.TransactionType;

public class TransactionFees {
    private TransactionType transactionType;
    private Double amount;
    private String currencyCode;
    private String feesStatus;
    private Double fees;
    private String feesCurrencyCode;

    public TransactionFees(TransactionType transactionType, Double amount, String currencyCode, String feesStatus, Double fees, String feesCurrencyCode) {
        super();

        this.setTransactionType(transactionType);
        this.setAmount(amount);
        this.setCurrencyCode(currencyCode);
        this.setStatus(feesStatus);
        this.setFees(fees);
        this.setFeesCurrencyCode(feesCurrencyCode);
    }

    public TransactionFees() {
        super();
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
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

    public String getStatus() {
        return feesStatus;
    }

    public void setStatus(String feesStatus) {
        this.feesStatus = feesStatus;
    }

    public Double getFees() {
        return fees;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }

    public String getFeesCurrencyCode() {
        return feesCurrencyCode;
    }

    public void setFeesCurrencyCode(String feesCurrencyCode) {
        this.feesCurrencyCode = feesCurrencyCode;
    }
}
