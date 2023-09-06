package com.wanted.preonboarding.cafe.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum Coffee {
    AMERICANO("AMERICANO", 100L),
    LATTE("LATTE", 150L),
    ADE("ADE", 200L);

    private final String name;
    private final long price;

    public static Coffee findByName(String name) {
        return Stream.of(values())
                .filter(coffee -> coffee.getName().equals(name))
                .findFirst().orElseThrow(RuntimeException::new);
    }
    }
