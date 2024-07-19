package com.demobank.account.port.adapter.controller.account;

public class OpenAccountResponse {
    private String status;

    public OpenAccountResponse() {}

    public OpenAccountResponse(String status) {
        this.setStatus(status);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}