package com.demobank.account.domain.model.currency;

public class ConvertedAmount {
    private String fromCurrencyCode;
    private Double amount;
    private String toCurrencyCode;
    private String currencyStatus;
    private Double convertedAmount;

    public ConvertedAmount(String fromCurrencyCode, Double amount, String toCurrencyCode, String currencyStatus, Double convertedAmount) {
        super();

        this.setFromCurrencyCode(fromCurrencyCode);
        this.setAmount(amount);
        this.setToCurrencyCode(toCurrencyCode);
        this.setStatus(currencyStatus);
        this.setConvertedAmount(convertedAmount);
    }

    public ConvertedAmount() {
        super();
    }

    public String getFromCurrencyCode() {
        return fromCurrencyCode;
    }

    public void setFromCurrencyCode(String fromCurrencyCode) {
        this.fromCurrencyCode = fromCurrencyCode;
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

    public String getStatus() {
        return currencyStatus;
    }

    public void setStatus(String currencyStatus) {
        this.currencyStatus = currencyStatus;
    }

    public Double getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(Double convertedAmount) {
        this.convertedAmount = convertedAmount;
    }
}
