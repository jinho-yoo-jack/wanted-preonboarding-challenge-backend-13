package com.wanted.preonboarding.theater.exception;

import org.springframework.http.ResponseEntity;

public class ErrFormatResponseBuilder {
    public static ResponseEntity<Object> build(ErrFormat errFormat){
        return new ResponseEntity<>(errFormat, errFormat.getStatus());
    }
}
