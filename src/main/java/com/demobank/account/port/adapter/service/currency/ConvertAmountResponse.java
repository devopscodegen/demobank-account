package com.demobank.account.port.adapter.service.currency;

public class ConvertAmountResponse {
    private String status;
    private Double convertedAmount;

    public ConvertAmountResponse() {}

    public ConvertAmountResponse(String status, Double convertedAmount) {
        this.setStatus(status);
        this.setConvertedAmount(convertedAmount);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(Double currency) {
        this.convertedAmount = currency;
    }
}