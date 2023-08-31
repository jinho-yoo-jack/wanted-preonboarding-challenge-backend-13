package com.wanted.preonboarding.cafe.service.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;

@Getter
@AllArgsConstructor
public class Cafe {
    private final String name;
    private Long sales;
    private Map<String, Integer> menu;
    private LinkedBlockingDeque<Barista> baristas;

    public void plusSales(Long amount){
        this.sales += amount;
    }
    public void minusSales(Long amount){
        this.sales -= amount;
    }
}
