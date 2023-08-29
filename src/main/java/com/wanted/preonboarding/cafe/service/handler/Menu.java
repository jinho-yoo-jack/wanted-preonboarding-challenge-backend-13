package com.wanted.preonboarding.cafe.service.handler;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Menu {
    AMERICANO(100L), LATTE(200L), ADE(300L);

    private final long price;
}
