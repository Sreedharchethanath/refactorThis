package com.xero.app.refactorthis.service.exception;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {

    private String errorCode;

    public ApiException(String errorMessage, String errorCode, Throwable error) {
        super(errorMessage, error);
        this.errorCode = errorCode;
    }

    public ApiException(String errorMessage,String errorCode) {
        super(errorMessage);
        this.errorCode = errorCode;
    }
}
