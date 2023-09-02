package com.wanted.preonboarding.cafe.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MenuEnum {
    AMERICANO(100L),
    JUICE(110L),
    TEA(120L);

    private long price;
}
