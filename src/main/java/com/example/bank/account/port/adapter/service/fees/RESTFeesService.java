package com.example.bank.account.port.adapter.service.fees;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.jmolecules.architecture.hexagonal.Adapter;
import org.springframework.http.MediaType;

import com.example.bank.account.domain.model.account.transaction.TransactionType;
import com.example.bank.account.domain.model.currency.CurrencyCode;
import com.example.bank.account.domain.model.fees.FeesService;
import com.example.bank.account.domain.model.fees.FeesStatus;
import com.example.bank.account.domain.model.fees.TransactionFees;
import com.example.bank.account.domain.model.money.Money;

@Service
@Adapter
public class RESTFeesService implements FeesService {

    private String baseUrl;

    private RestClient restClient;

    private RestClient.Builder restClientBuilder;

    public RESTFeesService() {
        super();
        this.setBaseUrl("http://localhost:8081/api/v1/fees");
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

    public TransactionFees calculateTransactionFees(TransactionType transactionType, Money amount) {
        TransactionFeesResponse transactionFeesResponse = this.getRestClient().post()
            .uri("/transaction")
            .contentType(MediaType.APPLICATION_JSON)
            .body(new TransactionFeesRequest(transactionType.toString(), amount.getAmount(), amount.getCurrencyCode().toString()))
            .retrieve()
            .body(TransactionFeesResponse.class);
        
        return new TransactionFees(
            transactionType, 
            amount, 
            FeesStatus.valueOf(transactionFeesResponse.getStatus()), 
            new Money(
                transactionFeesResponse.getFees(), 
                CurrencyCode.valueOf(transactionFeesResponse.getFeesCurrencyCode())
            )
        );
    }
}
