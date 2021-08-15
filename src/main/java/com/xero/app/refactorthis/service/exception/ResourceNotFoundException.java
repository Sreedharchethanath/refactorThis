package com.xero.app.refactorthis.service.exception;

public class ResourceNotFoundException extends ApiException {

    public ResourceNotFoundException(String errorMessage, String errorCode) {
        super(errorMessage, errorCode);
    }
}
