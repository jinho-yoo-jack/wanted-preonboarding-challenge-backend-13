package com.wanted.preonboarding.cafe.service.handler;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Beverage {

    AMERICANO(100L),
    CAFFE_LATTE(200L),
    LEMON_ADE(300L);

    private final long price;

}
