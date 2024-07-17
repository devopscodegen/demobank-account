package com.demobank.account.port.adapter.service.fees;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.http.MediaType;

import com.demobank.account.domain.model.fees.FeesService;
import com.demobank.account.domain.model.fees.FeesStatus;
import com.demobank.account.domain.model.fees.TransactionFees;
import com.demobank.account.domain.model.transaction.TransactionType;

@Service
public class FeesServiceREST implements FeesService {

    private String baseUrl;

    private RestClient restClient;

    private RestClient.Builder restClientBuilder;

    public FeesServiceREST() {
        super();
        this.setBaseUrl("http://localhost:8081/api/v1/fees");
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

    public TransactionFees calculateTransactionFees(TransactionType transactionType, double amount, String currency) {
        TransactionFeesResponse transactionFeesResponse = this.getRestClient().post()
            .uri("/transaction")
            .contentType(MediaType.APPLICATION_JSON)
            .body(new TransactionFeesRequest(transactionType.toString(), amount, currency))
            .retrieve()
            .body(TransactionFeesResponse.class);
        
        return new TransactionFees(transactionType, amount, currency, FeesStatus.valueOf(transactionFeesResponse.getStatus()), transactionFeesResponse.getFees(), transactionFeesResponse.getFeesCurrency());
    }
}
