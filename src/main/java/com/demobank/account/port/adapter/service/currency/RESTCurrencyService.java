package com.demobank.account.port.adapter.service.currency;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.http.MediaType;

import com.demobank.account.domain.model.currency.ConvertedAmount;
import com.demobank.account.domain.model.currency.CurrencyService;

@Service
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

    private String getBaseUrl() {
        return baseUrl;
    }

    private void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    private RestClient getRestClient() {
        return restClient;
    }

    private void setRestClient(RestClient restClient) {
        this.restClient = restClient;
    }

    private RestClient.Builder getRestClientBuilder() {
        return restClientBuilder;
    }

    private void setRestClientBuilder(RestClient.Builder restClientBuilder) {
        this.restClientBuilder = restClientBuilder;
    }

    public ConvertedAmount convertAmount(String fromCurrencyCode, Double amount, String toCurrencyCode) {
        ConvertAmountResponse convertAmountResponse = this.getRestClient().post()
            .uri("/{fromCurrencyCode}/convert", fromCurrencyCode)
            .contentType(MediaType.APPLICATION_JSON)
            .body(new ConvertAmountRequest(amount, toCurrencyCode))
            .retrieve()
            .body(ConvertAmountResponse.class);
        
        return new ConvertedAmount(fromCurrencyCode, amount, toCurrencyCode, convertAmountResponse.getStatus(), convertAmountResponse.getConvertedAmount());
    }
}
