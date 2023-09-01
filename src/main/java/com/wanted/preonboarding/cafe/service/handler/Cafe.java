package com.wanted.preonboarding.cafe.service.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Cafe {
    private String name;
    private Long sales;

    @Autowired
    private final Cashier cashier;
    
    @Autowired
    private final Barista barista;

    public String getCafeName(){
        return name;
    }
    
	public void plusSales(Long amount){
        this.sales += amount;
    }

    public void minusSales(Long amount){
        this.sales -= amount;
    }

	public Cashier getCashier() {
		return cashier;
	}

	public Barista getBarista() {
		return barista;
	}
}
