package com.wanted.preonboarding.cafe.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Drinks {

    AMERICANO(100L),
    CAPPUCCINO(110L),
    CAFFE_LATTE(120L);

    private final Long price;
}
