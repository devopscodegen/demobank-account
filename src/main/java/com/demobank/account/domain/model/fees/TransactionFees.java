package com.demobank.account.domain.model.fees;

import com.demobank.account.domain.model.account.transaction.TransactionType;
import com.demobank.account.domain.model.money.Money;

public class TransactionFees {
    private TransactionType transactionType;
    private Money amount;
    private FeesStatus feesStatus;
    private Money fees;

    public TransactionFees(TransactionType transactionType, Money amount, FeesStatus feesStatus, Money fees) {
        super();

        this.setTransactionType(transactionType);
        this.setAmount(amount);
        this.setStatus(feesStatus);
        this.setFees(fees);
    }

    public TransactionFees() {
        super();
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    private void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Money getAmount() {
        return amount;
    }

    private void setAmount(Money amount) {
        this.amount = amount;
    }

    public FeesStatus getStatus() {
        return feesStatus;
    }

    private void setStatus(FeesStatus feesStatus) {
        this.feesStatus = feesStatus;
    }

    public Money getFees() {
        return fees;
    }

    private void setFees(Money fees) {
        this.fees = fees;
    }
}
