package com.demobank.account.domain.model.fees;

import com.demobank.account.domain.model.account.transaction.TransactionType;
import com.demobank.account.domain.model.money.Money;

public interface FeesService {
	public TransactionFees calculateTransactionFees(TransactionType transactionType, Money amount);
}
