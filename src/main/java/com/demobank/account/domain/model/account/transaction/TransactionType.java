package com.demobank.account.domain.model.account.transaction;

public enum TransactionType {

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
