package com.demobank.account.domain.model.transaction;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class TransactionIdService {
    public UUID nextIdentity() {
        return UUID.randomUUID();
    }
}
