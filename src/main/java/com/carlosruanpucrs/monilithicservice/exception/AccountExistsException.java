package com.carlosruanpucrs.monilithicservice.exception;

public class AccountExistsException extends RuntimeException {

    private static final String message = "numero conta já existente";

    public AccountExistsException() {
        super(message);
    }
}
