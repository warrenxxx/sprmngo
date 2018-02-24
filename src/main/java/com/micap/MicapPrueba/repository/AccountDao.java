package com.micap.MicapPrueba.repository;

import com.micap.MicapPrueba.entity.Account;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AccountDao extends ReactiveMongoRepository<Account,String> {
}
