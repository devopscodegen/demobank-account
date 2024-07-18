package com.demobank.account.port.adapter.service.currency;

public class ConvertAmountRequest {

    private Double amount;
    private String toCurrencyCode;

    public ConvertAmountRequest(Double amount, String toCurrencyCode) {
        super();

        this.setAmount(amount);
        this.setToCurrencyCode(toCurrencyCode);
    }

    public ConvertAmountRequest() {
        super();
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getToCurrencyCode() {
        return toCurrencyCode;
    }

    public void setToCurrencyCode(String toCurrencyCode) {
        this.toCurrencyCode = toCurrencyCode;
    }
}