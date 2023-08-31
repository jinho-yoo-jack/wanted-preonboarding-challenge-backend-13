package com.wanted.preonboarding.cafe.service.handler;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Cafe {
    private final String name;
    private Long sales;
    private Barista barista;
    private Menu menu;
    private Cashier cashier;

    @Autowired
    public Cafe(Barista barista, Menu menu, Cashier cashier) {
        this.name = "wantedCodingCafe";
        this.sales = 10000L;
        this.barista = barista;
        this.menu = menu;
        this.cashier = cashier;
    }

    public void plusSales(Long amount) {
        this.sales += amount;
    }
}
