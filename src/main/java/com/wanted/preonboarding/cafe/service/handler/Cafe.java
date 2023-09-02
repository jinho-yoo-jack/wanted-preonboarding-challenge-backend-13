package com.wanted.preonboarding.cafe.service.handler;

import org.springframework.stereotype.Component;

@Component
public class Cafe {
    private String name;
    private Long sales;

    public Cafe() {
        this.name = "wantedCodingCafe";
        this.sales = 10000L;
    }

    public void plusSales(Long amount) {
        this.sales += amount;
    }
}
