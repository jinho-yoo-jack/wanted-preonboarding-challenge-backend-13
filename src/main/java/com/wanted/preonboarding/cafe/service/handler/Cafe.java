package com.wanted.preonboarding.cafe.service.handler;

import org.springframework.stereotype.Component;

@Component
public class Cafe {
    private String name;
    private Long sales;
    private Cashier cashier;
    private Barista barista;

    public Barista getBarista() {
		return barista;
	}

	public void setBarista(Barista barista) {
		this.barista = barista;
	}

	public Cafe (Cashier cashier) {
    	this.name = "wantedCodingCafe";
		this.cashier = cashier;
    }

    public String getCafeName(){
        return name;
    }
    
    public Cashier getCashier() {
    	return cashier;
    }
    
	public void plusSales(Long amount){
        this.sales += amount;
    }

    public void minusSales(Long amount){
        this.sales -= amount;
    }
}
