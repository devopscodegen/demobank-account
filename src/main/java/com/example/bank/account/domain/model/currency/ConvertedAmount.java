package com.example.bank.account.domain.model.currency;

import org.jmolecules.ddd.annotation.ValueObject;

import com.example.bank.account.domain.model.common.BaseValueObject;
import com.example.bank.account.domain.model.money.Money;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@ValueObject
public class ConvertedAmount implements BaseValueObject{
    private Money amount;
    private CurrencyCode toCurrencyCode;
    private CurrencyStatus currencyStatus;
    private Money convertedAmount;
}
