package com.example.bank.account.domain.model.account;

import org.jmolecules.ddd.annotation.Repository;

import com.example.bank.account.domain.model.common.BaseRepository;

@Repository
public interface AccountRepository extends BaseRepository<Account, AccountId>{
    
}