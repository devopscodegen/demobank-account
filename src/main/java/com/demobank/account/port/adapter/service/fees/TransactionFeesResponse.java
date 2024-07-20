package com.demobank.account.port.adapter.service.fees;

import java.math.BigDecimal;

public class TransactionFeesResponse {
    private String status;
    private BigDecimal fees;
    private String feesCurrencyCode;

    public TransactionFeesResponse() {}

    public TransactionFeesResponse(String status, BigDecimal fees, String feesCurrencyCode) {
        this.setStatus(status);
        this.setFees(fees);
        this.setFeesCurrencyCode(feesCurrencyCode);
    }

    public String getStatus() {
        return status;
    }

    private void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getFees() {
        return fees;
    }

    private void setFees(BigDecimal fees) {
        this.fees = fees;
    }

    public String getFeesCurrencyCode() {
        return feesCurrencyCode;
    }

    private void setFeesCurrencyCode(String feesCurrencyCode) {
        this.feesCurrencyCode = feesCurrencyCode;
    }
}