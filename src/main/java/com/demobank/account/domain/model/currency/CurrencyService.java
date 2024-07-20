package com.demobank.account.domain.model.currency;

import com.demobank.account.domain.model.money.Money;

public interface CurrencyService {
	public ConvertedAmount convertAmount(Money amount, CurrencyCode toCurrencyCode);
}
