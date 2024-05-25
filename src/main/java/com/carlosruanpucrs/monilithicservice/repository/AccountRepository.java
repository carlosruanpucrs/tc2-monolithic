package com.carlosruanpucrs.monilithicservice.repository;

import com.carlosruanpucrs.monilithicservice.model.AccountEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends MongoRepository<AccountEntity, Integer> {

    AccountEntity findAccountByNumber(Integer number);
}
