package com.carlosruanpucrs.monilithicservice.service;

import com.carlosruanpucrs.monilithicservice.controller.request.AccountRequest;
import com.carlosruanpucrs.monilithicservice.controller.response.AccountResponse;
import com.carlosruanpucrs.monilithicservice.exception.AccountExistsException;
import com.carlosruanpucrs.monilithicservice.model.AccountEntity;
import com.carlosruanpucrs.monilithicservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Service
public class AccountService {

    @Autowired
    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public AccountResponse createAccount(AccountRequest request) {
        Integer number = generateAccountNumber();
        accountExists(number);
        var entity = mapToEntity(request);

        repository.insert(entity);
        return new AccountResponse();
    }

    private static AccountEntity mapToEntity(AccountRequest request) {
        var entity = new AccountEntity();
        entity.setDocument(request.getDocument());
        entity.setCustomerName(request.getCustomerName());
        entity.setStatus("ATIVADO");
        entity.setCreatedAt(LocalDate.now());
        entity.setBranch("001");
        entity.setBalance(BigDecimal.ZERO);
        return entity;
    }

    private Integer generateAccountNumber() {
       return (int) (Math.random() * 29);
    }

    private void accountExists(Integer accountNumber){
        var account = repository.findAccountByNumber(accountNumber);
        if(Objects.nonNull(account)){
            throw new AccountExistsException();
        }
    }
}
