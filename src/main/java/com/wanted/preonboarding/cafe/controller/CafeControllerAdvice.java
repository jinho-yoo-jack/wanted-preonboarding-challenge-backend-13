package com.wanted.preonboarding.cafe.controller;

import com.wanted.preonboarding.cafe.domain.InvalidResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice(basePackages = {"com.wanted.preonboarding.cafe"})
public class CafeControllerAdvice {
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(RuntimeException.class)
    public String runtimeExceptionHandler(RuntimeException e){
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ConstraintViolationException.class})
    public List<InvalidResponse> constraintViolationExceptionHandler(ConstraintViolationException e) {

        List<InvalidResponse> responses = new ArrayList<>();

        e.getConstraintViolations().forEach(fieldError -> {
            responses.add(new InvalidResponse(fieldError.getPropertyPath().toString(), fieldError.getMessage(), fieldError.getInvalidValue()));
        });

        return responses;
    }
}
