package com.demobank.account.port.adapter.service.fees;

public class TransactionFeesRequest {

    private String transactionType;
    private Double amount;
    private String currencyCode;

    public TransactionFeesRequest(String transactionType, Double amount, String currencyCode) {
        super();

        this.setTransactionType(transactionType);
        this.setAmount(amount);
        this.setCurrencyCode(currencyCode);
    }

    public TransactionFeesRequest() {
        super();
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
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
}