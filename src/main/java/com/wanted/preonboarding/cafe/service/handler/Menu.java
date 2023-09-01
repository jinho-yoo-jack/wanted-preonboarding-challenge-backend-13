package com.wanted.preonboarding.cafe.service.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
public enum Menu {
    AMERICANO("AMERICANO",3000),
    CAPPUCCINO("CAPPUCCINO",4500),
    LATTE("LATTE",4500);
    private String name;
    @Getter
    private Integer cost;
}
