package com.demobank.account.domain.model.fees;

import com.demobank.account.domain.model.transaction.TransactionType;

public interface FeesService {
	public TransactionFees calculateTransactionFees(TransactionType transactionType, double amount, String currency);
}
