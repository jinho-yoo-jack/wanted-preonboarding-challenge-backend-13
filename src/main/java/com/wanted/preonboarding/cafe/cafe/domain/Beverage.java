package com.wanted.preonboarding.cafe.cafe.domain;

public enum Beverage {
    AMERICANO("아메리카노", 3_000L),
    CAFE_LATTE("카페라떼", 4_000L),
    ESPRESSO("에스프레소", 2_500L),
    HOT_CHOCO("핫초코", 4_000L),
    ;

    private final String name;
    private final long cost;

    Beverage(String name, long cost) {
        this.name = name;
        this.cost = cost;
    }


    public String getName() {
        return name;
    }

    public long getCost() {
        return cost;
    }
}
