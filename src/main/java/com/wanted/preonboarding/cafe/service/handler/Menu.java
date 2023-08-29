package com.wanted.preonboarding.cafe.service.handler;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Menu {
    AMERICANO(100L), LATTE(150L), MOCHA(200L);

    private final Long price;
}
