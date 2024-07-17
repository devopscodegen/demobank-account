package com.demobank.account.port.adapter.service.fees;

public class TransactionFeesRequest {

    private String transactionType;
    private Double amount;
    private String currency;

    public TransactionFeesRequest(String transactionType, Double amount, String currency) {
        super();

        this.setTransactionType(transactionType);
        this.setAmount(amount);
        this.setCurrency(currency);
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}