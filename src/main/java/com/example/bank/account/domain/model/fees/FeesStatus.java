package com.example.bank.account.domain.model.fees;

import org.jmolecules.ddd.annotation.ValueObject;

import com.example.bank.account.domain.model.common.BaseValueObject;

@ValueObject
public enum FeesStatus implements BaseValueObject{

    SUCCESS {
        public boolean isSuccess() {
            return true;
        }
    },

    FAILED {
        public boolean isFailed() {
            return true;
        }
    };

    public boolean isSuccess() {
        return false;
    }

    public boolean isFailed() {
        return false;
    }

    public FeesStatus regress() {
        if (this.isSuccess()) {
            return SUCCESS;
        } else if (this.isFailed()) {
            return FAILED;
        }

        return SUCCESS;
    }
}
