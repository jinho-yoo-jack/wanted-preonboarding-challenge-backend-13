package com.wanted.preonboarding.cafe.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Menu {
    AMERICANO(100L),
    CAFE_LATTE(200L),
    ICE_CHOCO(250L),
    ICE_MANGO(300L);

    private final Long amount;

    @JsonCreator
    public static Menu fromInput(String input){
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.name().equals(input))
                .findFirst()
                .orElse(null);
    }
}
