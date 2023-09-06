package com.wanted.preonboarding.cafe.service.handler;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class Cafe {

    private String name;
    private Long sales;
    private Cashier cashier;
    private Barista barista;

    public String getCafeName(){
        return name;
    }

    public void plusSales(Long amount){
        this.sales += amount;
    }

    public void minusSales(Long amount){
        this.sales -= amount;
    }

    public String takeOrder(Map<Beverage, Integer> myOrders) {
        long totalPrice = cashier.calculateTotalPrice(myOrders);
        this.plusSales(totalPrice);
        return barista.makeCoffeeTo(myOrders);
    }

}
