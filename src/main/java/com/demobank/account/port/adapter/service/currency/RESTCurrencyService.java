package com.demobank.account.port.adapter.service.currency;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.jmolecules.architecture.hexagonal.Adapter;
import org.springframework.http.MediaType;

import com.demobank.account.domain.model.currency.ConvertedAmount;
import com.demobank.account.domain.model.currency.CurrencyCode;
import com.demobank.account.domain.model.currency.CurrencyService;
import com.demobank.account.domain.model.currency.CurrencyStatus;
import com.demobank.account.domain.model.money.Money;

@Service
@Adapter
public class RESTCurrencyService implements CurrencyService {

    private String baseUrl;

    private RestClient restClient;

    private RestClient.Builder restClientBuilder;

    public RESTCurrencyService() {
        super();
        this.setBaseUrl("http://localhost:8082/api/v1/currency");
        this.setRestClientBuilder(RestClient.builder());
        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(this.getBaseUrl());
        this.setRestClient(this.getRestClientBuilder().uriBuilderFactory(factory).build());
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    private void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public RestClient getRestClient() {
        return restClient;
    }

    private void setRestClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public RestClient.Builder getRestClientBuilder() {
        return restClientBuilder;
    }

    private void setRestClientBuilder(RestClient.Builder restClientBuilder) {
        this.restClientBuilder = restClientBuilder;
    }

    public ConvertedAmount convertAmount(Money amount, CurrencyCode toCurrencyCode) {
        ConvertAmountResponse convertAmountResponse = this.getRestClient().post()
            .uri("/{fromCurrencyCode}/convert", amount.getCurrencyCode().toString())
            .contentType(MediaType.APPLICATION_JSON)
            .body(new ConvertAmountRequest(amount.getCurrencyCode().toString(), amount.getAmount(), toCurrencyCode.toString()))
            .retrieve()
            .body(ConvertAmountResponse.class);
        
        return new ConvertedAmount(
            amount, 
            toCurrencyCode, 
            CurrencyStatus.valueOf(convertAmountResponse.getStatus()), 
            new Money(convertAmountResponse.getConvertedAmount(),toCurrencyCode));
    }
}
