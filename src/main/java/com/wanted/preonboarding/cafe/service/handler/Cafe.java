package com.wanted.preonboarding.cafe.service.handler;

import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class Cafe {
    private final String name;
    private BigInteger sales;

    public Cafe(){
        this.name = "wantedCodingCafe";
        this.sales = BigInteger.valueOf(10000);
    }

    public void plusSales(BigInteger amount){
        this.sales = this.sales.add(amount);
    }
}
