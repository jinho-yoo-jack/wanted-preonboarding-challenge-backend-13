package com.wanted.preonboarding.cafe.exception;

import lombok.Getter;

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
        if(message == null) {
            return errorCode.getMessage();
        }
        return String.format("%s. %s", errorCode.getMessage(), message);
    }
}
