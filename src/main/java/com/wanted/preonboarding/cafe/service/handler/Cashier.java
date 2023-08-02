package com.wanted.preonboarding.cafe.service.handler;

import java.util.HashMap;
import java.util.Map;

public class Cashier {
    private Map<String, Integer> order;
    private final Cafe cafe;

    public Cashier(Cafe cafe){
        this.cafe = cafe;
    }

    public void setOrder(Map<String, Integer> orderBook){
        this.order = orderBook;
    }

    public long calculateTotalPrice(){
        long totalPrice = 0L;
        long americanoPrice = 100L;
        for(String key : order.keySet()){
            if(key.equalsIgnoreCase("AMERICANO"))
                totalPrice += americanoPrice * order.get(key);
        }
        return totalPrice;
    }

    public boolean payment(String paymentMethod, long totalPrice){
        // 지불요쳥.
        return false;
    }
}
