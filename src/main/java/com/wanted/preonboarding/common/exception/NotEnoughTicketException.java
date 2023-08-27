package com.wanted.preonboarding.common.exception;

public class NotEnoughTicketException extends RuntimeException {
    public NotEnoughTicketException() {
    }

    public NotEnoughTicketException(String message) {
        super(message);
    }

    public NotEnoughTicketException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughTicketException(Throwable cause) {
        super(cause);
    }

    public NotEnoughTicketException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
