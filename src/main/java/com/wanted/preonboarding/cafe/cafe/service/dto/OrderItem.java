package com.wanted.preonboarding.cafe.cafe.service.dto;

import com.wanted.preonboarding.cafe.cafe.domain.Beverage;

public class OrderItem {
    private Beverage beverage;
    private long count;

    public Beverage getBeverage() {
        return beverage;
    }

    public long getCount() {
        return count;
    }
}
