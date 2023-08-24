package com.wanted.preonboarding.cafe.service.handler;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class Cafe {
    private final String name;
    private final AtomicLong sales;

    public Cafe(){
        this.name = "wantedCodingCafe";
        this.sales = new AtomicLong(10000L);
    }

    public String getCafeName(){
        return name;
    }

    public void plusSales(Long amount){
        sales.addAndGet(amount);
    }

    public void minusSales(Long amount){
        sales.addAndGet(-amount);
    }
}
