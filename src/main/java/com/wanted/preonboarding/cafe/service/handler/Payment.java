package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.exception.CafeErrorCode;
import com.wanted.preonboarding.cafe.exception.CafeException;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum Payment {
    CARD,
    CASH
    ;

    public static Optional<Payment> fromString(String value) {
        try {
            return Optional.of(Payment.valueOf(value.toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new CafeException(CafeErrorCode.PAYMENT_NOT_ACCEPTABLE);
        }
    }
}
