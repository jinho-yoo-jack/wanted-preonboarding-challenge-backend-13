package com.wanted.preonboarding.cafe.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Menu {
    AMERICANO(100L),
    CAFE_LATTE(200L),
    ICE_CHOCO(250L),
    ICE_MANGO(300L);

    private final Long amount;
}
