package com.demobank.account.domain.model.currency;

public interface CurrencyService {
	public ConvertedAmount convertAmount(String fromCurrencyCode, Double amount, String toCurrencyCode);
}
