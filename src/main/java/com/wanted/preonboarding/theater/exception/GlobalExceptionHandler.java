package com.wanted.preonboarding.theater.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotEnoughAmountException.class)
    public String handleNotEnoughAmountException (Exception e) {
        return e.getMessage();
    }

}
