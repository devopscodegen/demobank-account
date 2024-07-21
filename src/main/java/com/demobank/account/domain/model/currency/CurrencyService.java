package com.demobank.account.domain.model.currency;

import org.jmolecules.architecture.hexagonal.Port;
import org.jmolecules.ddd.annotation.Service;

import com.demobank.account.domain.model.money.Money;

@Service
@Port
public interface CurrencyService {
	public ConvertedAmount convertAmount(Money amount, CurrencyCode toCurrencyCode);
}
