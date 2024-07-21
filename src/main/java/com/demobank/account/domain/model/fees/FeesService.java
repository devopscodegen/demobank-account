package com.demobank.account.domain.model.fees;

import org.jmolecules.architecture.hexagonal.Port;
import org.jmolecules.ddd.annotation.Service;

import com.demobank.account.domain.model.account.transaction.TransactionType;
import com.demobank.account.domain.model.money.Money;

@Service
@Port
public interface FeesService {
	public TransactionFees calculateTransactionFees(TransactionType transactionType, Money amount);
}
