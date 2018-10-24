package com.coding.challenge.api;

public class InvalidTransactionError extends ApiError{

    private String[] errorParams;

    public InvalidTransactionError(String message, String errorCode, String...params) {
        super(message, errorCode);
        this.errorParams = params;
    }

    public String[] getErrorParams() {
        return errorParams;
    }
}
