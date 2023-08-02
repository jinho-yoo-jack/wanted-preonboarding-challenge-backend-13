package com.wanted.preonboarding.cafe.service.handler;

public class Cafe {
    private Long sales;

    public Cafe(Long sales){
        this.sales = sales;
    }

    public void plusSales(Long amount){
        this.sales += amount;
    }

    public void minusSales(Long amount){
        this.sales -= amount;
    }
}
