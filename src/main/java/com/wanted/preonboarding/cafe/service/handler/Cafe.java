package com.wanted.preonboarding.cafe.service.handler;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Cafe {
    private final String name;
    private final Barista barista;
    private Long sales;

    public Cafe(){
        this.barista = new Barista(0, 0);
        this.name = "wantedCodingCafe";
        this.sales = 10000L;
    }

    public String getCafeName(){
        return name;
    }

    public void plusSales(Long amount){
        this.sales += amount;
    }

    public void minusSales(Long amount){
        this.sales -= amount;
    }

    public String sendTo(Map<String, Integer> receivedOrders) {
        return this.barista.makeCoffeeTo(receivedOrders);
    }
}
