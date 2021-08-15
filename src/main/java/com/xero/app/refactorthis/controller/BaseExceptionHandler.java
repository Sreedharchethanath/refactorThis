package com.xero.app.refactorthis.controller;


import com.xero.app.refactorthis.service.exception.ResourceNotFoundException;
import com.xero.app.refactorthis.service.exception.SystemException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class BaseExceptionHandler {

    @Autowired
    ApiError apiError;

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiError> handleResourceNotFoundException(ResourceNotFoundException exception, HttpServletRequest request) {
        apiError.setErrorCode("NOT_FOUND");
        apiError.setErrorMessage(exception.getMessage());
        apiError.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SystemException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ApiError> handleSystemException(SystemException exception, HttpServletRequest request) {
        apiError.setErrorCode("ERROR_DURING_MODIFY");
        apiError.setErrorMessage("Error while creating/updating/deleting");
        apiError.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ApiError>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
