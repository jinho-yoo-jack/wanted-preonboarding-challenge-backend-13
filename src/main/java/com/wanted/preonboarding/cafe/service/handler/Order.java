package com.wanted.preonboarding.cafe.service.handler;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Order {

    private final Beverage beverage;
    private final int quantity;

}
