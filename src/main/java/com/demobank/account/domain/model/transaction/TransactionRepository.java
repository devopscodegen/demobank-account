package com.demobank.account.domain.model.transaction;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, UUID>{
    
}