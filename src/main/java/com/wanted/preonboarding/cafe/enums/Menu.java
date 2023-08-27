package com.wanted.preonboarding.cafe.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.math.BigInteger;
import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Menu {
    AMERICANO(BigInteger.valueOf(100)),
    LATTE(BigInteger.valueOf(120)),
    ADE(BigInteger.valueOf(130))
    ;

    private final BigInteger price;

    public static Menu of(String name) {
        if (!StringUtils.hasText(name)) {
            throw new IllegalArgumentException();
        }

        return Arrays.stream(values())
                .filter(menu -> menu.toString().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
