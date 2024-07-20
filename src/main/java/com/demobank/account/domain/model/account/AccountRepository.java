package com.demobank.account.domain.model.account;

import org.jmolecules.ddd.types.Repository;

import com.demobank.account.domain.model.common.BaseRepository;

public interface AccountRepository extends Repository<Account, AccountId>, BaseRepository<Account, AccountId>{
    
}