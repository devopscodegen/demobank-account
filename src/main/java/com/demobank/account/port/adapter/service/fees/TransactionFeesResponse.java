package com.demobank.account.port.adapter.service.fees;

public class TransactionFeesResponse {
    private String status;
    private Double fees;
    private String feesCurrencyCode;

    public TransactionFeesResponse() {}

    public TransactionFeesResponse(String status, Double fees, String feesCurrencyCode) {
        this.setStatus(status);
        this.setFees(fees);
        this.setFeesCurrencyCode(feesCurrencyCode);
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

    public String getFeesCurrencyCode() {
        return feesCurrencyCode;
    }

    public void setFeesCurrencyCode(String feesCurrencyCode) {
        this.feesCurrencyCode = feesCurrencyCode;
    }
}