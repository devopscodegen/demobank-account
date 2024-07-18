package com.demobank.account.port.adapter.service.fees;

public class TransactionFeesResponse {
    private String status;
    private Double fees;
    private String feesCurrency;

    public TransactionFeesResponse() {}

    public TransactionFeesResponse(String status, Double fees, String feesCurrency) {
        this.setStatus(status);
        this.setFees(fees);
        this.setFeesCurrency(feesCurrency);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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