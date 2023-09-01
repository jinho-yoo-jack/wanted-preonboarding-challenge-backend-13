package com.wanted.preonboarding.cafe.service.handler;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Cafe {
    private final String name = "wantedCodingCafe";
    private Long sales = 10000L;

    public String getCafeName(){
        return name;
    }

    public void plusSales(Long amount){
        this.sales += amount;
    }

    public void minusSales(Long amount){
        this.sales -= amount;
    }
}
