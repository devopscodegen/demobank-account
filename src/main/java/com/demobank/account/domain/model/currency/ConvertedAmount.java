package com.demobank.account.domain.model.currency;

import com.demobank.account.domain.model.money.Money;

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
public class ConvertedAmount {
    private Money amount;
    private CurrencyCode toCurrencyCode;
    private CurrencyStatus currencyStatus;
    private Money convertedAmount;
}
