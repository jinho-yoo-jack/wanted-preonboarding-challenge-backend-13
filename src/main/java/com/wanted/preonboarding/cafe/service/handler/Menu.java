package com.wanted.preonboarding.cafe.service.handler;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Menu {

    AMERICANO(4100L),
    LATTE(4800L),
    ICE_CHOCO(4500L);

    private final long price;
}
