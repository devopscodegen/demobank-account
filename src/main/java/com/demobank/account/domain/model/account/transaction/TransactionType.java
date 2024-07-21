package com.demobank.account.domain.model.account.transaction;

import org.jmolecules.ddd.annotation.ValueObject;

import com.demobank.account.domain.model.common.BaseValueObject;

@ValueObject
public enum TransactionType implements BaseValueObject{

    WITHDRAW {
        public boolean iswithdrawAmountFromAccount() {
            return true;
        }
    },

    DEPOSIT {
        public boolean isdepositAmountToAccount() {
            return true;
        }
    };

    public boolean iswithdrawAmountFromAccount() {
        return false;
    }

    public boolean isdepositAmountToAccount() {
        return false;
    }

    public TransactionType regress() {
        if (this.iswithdrawAmountFromAccount()) {
            return WITHDRAW;
        } else if (this.isdepositAmountToAccount()) {
            return DEPOSIT;
        }

        return WITHDRAW;
    }
}
