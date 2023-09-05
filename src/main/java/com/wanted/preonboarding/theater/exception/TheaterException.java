package com.wanted.preonboarding.theater.exception;

import lombok.Getter;

import java.util.Optional;

@Getter
public class TheaterException extends RuntimeException {

    private TheaterErrorCode errorCode;
    private String message;

    public TheaterException(TheaterErrorCode errorCode) {
        this.errorCode = errorCode;
        this.message = null;
    }

    public TheaterException(TheaterErrorCode errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getMessage() {
        return Optional.ofNullable(message)
                .orElse(errorCode.getMessage());
    }
}
