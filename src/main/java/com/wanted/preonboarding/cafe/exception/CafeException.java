package com.wanted.preonboarding.cafe.exception;

import lombok.Getter;

import java.util.Optional;

@Getter
public class CafeException extends RuntimeException {

    private CafeErrorCode errorCode;
    private String message;

    public CafeException(CafeErrorCode errorCode) {
        this.errorCode = errorCode;
        this.message = null;
    }

    public CafeException(CafeErrorCode errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getMessage() {
        return Optional.ofNullable(message)
                .orElse(errorCode.getMessage());
    }

}
