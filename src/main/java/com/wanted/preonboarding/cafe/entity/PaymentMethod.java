package com.wanted.preonboarding.cafe.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentMethod {
    CARD("card");
    private final String name;
}
