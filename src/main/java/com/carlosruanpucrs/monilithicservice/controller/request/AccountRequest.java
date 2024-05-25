package com.carlosruanpucrs.monilithicservice.controller.request;

public class AccountRequest {

    private String document;
    private String customerName;

    public AccountRequest(String document, String customerName) {
        this.document = document;
        this.customerName = customerName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
