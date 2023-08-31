package com.wanted.preonboarding.theater.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(LackOfBalanceException.class)
    public ResponseEntity<ErrorResponse> handleLackOfBalanceException(LackOfBalanceException ex) {
        ErrorResponse errorResponse = ErrorResponse.create(ex, HttpStatus.PAYMENT_REQUIRED, ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}

