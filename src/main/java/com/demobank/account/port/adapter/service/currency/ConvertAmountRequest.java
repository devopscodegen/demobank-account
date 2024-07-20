package com.demobank.account.port.adapter.service.currency;

import java.math.BigDecimal;

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
public class ConvertAmountRequest {

    private String fromCurrencyCode;
    private BigDecimal amount;
    private String toCurrencyCode;
}