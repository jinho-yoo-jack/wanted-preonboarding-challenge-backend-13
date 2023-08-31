package com.wanted.preonboarding.cafe.service.handler;

import lombok.Getter;

@Getter
public class Beverage {
    private String name;
    private int fee;

    public Beverage(String name, int fee) {
        this.name = name;
        this.fee = fee;
    }
}
