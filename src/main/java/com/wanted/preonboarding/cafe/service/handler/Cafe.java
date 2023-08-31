package com.wanted.preonboarding.cafe.service.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Cafe {
    private final String name;
    private Long sales;
    private Map<String, Long> drinkFee; 
    
    public Cafe(){
        this.name = "wantedCodingCafe";
        this.sales = 10000L;
        this.drinkFee = new HashMap<String, Long>();
        drinkFee.put("AMERICANO", 200L);
        drinkFee.put("LATTE", 400L);
        drinkFee.put("COCOA", 300L);
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

	public Long getSales() {
		return sales;
	}

	public void setSales(Long sales) {
		this.sales = sales;
	}

	public Map<String, Long> getDrinkFee() {
		return drinkFee;
	}

	public void setDrinkFee(Map<String, Long> drinkFee) {
		this.drinkFee = drinkFee;
	}

	public String getName() {
		return name;
	}
    
    
}
