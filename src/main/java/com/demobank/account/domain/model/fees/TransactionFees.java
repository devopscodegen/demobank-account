package com.demobank.account.domain.model.fees;

import com.demobank.account.domain.model.transaction.TransactionType;

public class TransactionFees {
    private TransactionType transactionType;
    private Double amount;
    private String currency;
    private String feesStatus;
    private Double fees;
    private String feesCurrency;

    public TransactionFees(TransactionType transactionType, Double amount, String currency, String feesStatus, Double fees, String feesCurrency) {
        super();

        this.setTransactionType(transactionType);
        this.setAmount(amount);
        this.setCurrency(currency);
        this.setStatus(feesStatus);
        this.setFees(fees);
        this.setFeesCurrency(feesCurrency);
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    public String getFeesCurrency() {
        return feesCurrency;
    }

    public void setFeesCurrency(String feesCurrency) {
        this.feesCurrency = feesCurrency;
    }
}
