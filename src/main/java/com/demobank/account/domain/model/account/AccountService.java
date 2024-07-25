package com.demobank.account.domain.model.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demobank.account.domain.model.account.transaction.TransactionType;
import com.demobank.account.domain.model.currency.CurrencyService;
import com.demobank.account.domain.model.fees.FeesService;
import com.demobank.account.domain.model.money.Money;

@Service
@org.jmolecules.ddd.annotation.Service
public class AccountService {

    @Autowired
    private FeesService feesService;

    @Autowired
    private CurrencyService currencyService;

    public Money convertAmount(Account account, Money amount) {

        return this.currencyService.convertAmount(
                amount,
                account.getBalance().getCurrencyCode()
            ).getConvertedAmount();
    }

    public Money calculateTransactionFees(TransactionType transactionType, Money amount) {
        return this.feesService.calculateTransactionFees(
                transactionType, 
                amount
            ).getFees();
    }
}
