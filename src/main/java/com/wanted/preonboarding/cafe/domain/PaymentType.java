package com.wanted.preonboarding.cafe.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum PaymentType {
    CARD,
    CASH;

    @JsonCreator
    public static PaymentType fromInput(String input){
        return Arrays.stream(PaymentType.values())
                .filter(paymentType -> paymentType.name().equals(input))
                .findFirst()
                .orElse(null);
    }
}
