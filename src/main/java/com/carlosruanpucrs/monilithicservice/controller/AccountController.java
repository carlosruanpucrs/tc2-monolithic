package com.carlosruanpucrs.monilithicservice.controller;

import com.carlosruanpucrs.monilithicservice.controller.request.AccountRequest;
import com.carlosruanpucrs.monilithicservice.controller.response.AccountResponse;
import com.carlosruanpucrs.monilithicservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public AccountResponse openAccount(@RequestBody AccountRequest request){
      return accountService.createAccount(request);
    }
}
