package com.xero.app.refactorthis.service.exception;

public class SystemException extends ApiException {
    public SystemException(String errorMessage, String errorCode) {
        super(errorMessage, errorCode);
    }
}
