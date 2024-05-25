package com.carlosruanpucrs.monilithicservice.controller.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AccountResponse {

    private String document;
    private String customerName;
    private String accountNumber;
    private String status;
    private LocalDate createdAt;
    private BigDecimal balance;
}
