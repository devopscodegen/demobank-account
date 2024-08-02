package com.example.bank.account.domain.model.account.transaction;

import com.example.bank.account.domain.model.common.BaseValueObject;

public enum TransactionType implements BaseValueObject{

    DEBIT {
        public boolean isDebit() {
            return true;
        }
    },

    CREDIT {
        public boolean isCredit() {
            return true;
        }
    };

    public boolean isDebit() {
        return false;
    }

    public boolean isCredit() {
        return false;
    }

    public TransactionType regress() {
        if (this.isDebit()) {
            return DEBIT;
        } else if (this.isCredit()) {
            return CREDIT;
        }

        return DEBIT;
    }
}
