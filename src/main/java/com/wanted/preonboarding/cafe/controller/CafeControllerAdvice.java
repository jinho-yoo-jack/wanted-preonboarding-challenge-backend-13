package com.wanted.preonboarding.cafe.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = {"com.wanted.preonboarding.cafe"})
public class CafeControllerAdvice {
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(RuntimeException.class)
    public String runtimeExceptionHandler(RuntimeException e){
        return e.getMessage();
    }
}
