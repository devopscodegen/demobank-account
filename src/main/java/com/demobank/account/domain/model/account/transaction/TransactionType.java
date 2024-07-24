package com.demobank.account.domain.model.account.transaction;

import org.jmolecules.ddd.annotation.ValueObject;

import com.demobank.account.domain.model.common.BaseValueObject;

@ValueObject
public enum TransactionType implements BaseValueObject{

    WITHDRAW {
        public boolean isdebitAmountFromAccount() {
            return true;
        }
    },

    DEPOSIT {
        public boolean iscreditAmountToAccount() {
            return true;
        }
    };

    public boolean isdebitAmountFromAccount() {
        return false;
    }

    public boolean iscreditAmountToAccount() {
        return false;
    }

    public TransactionType regress() {
        if (this.isdebitAmountFromAccount()) {
            return WITHDRAW;
        } else if (this.iscreditAmountToAccount()) {
            return DEPOSIT;
        }

        return WITHDRAW;
    }
}
