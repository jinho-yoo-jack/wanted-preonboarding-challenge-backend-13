package com.wanted.preonboarding.cafe.service.handler;

import java.util.Map;

public class Customer {
    private String paymentMethod;
    private final Map<String, Integer> myOrders;
    private long totalPrice;

    public Customer(String paymentMethod, Map<String, Integer> orders, Long totalPrice) {
        this.paymentMethod = paymentMethod;
        this.myOrders = orders;
        this.totalPrice = totalPrice;
    }

    private void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    
	public Long getTotalPrice() {
		return totalPrice;
	}
	
	public String getPaymentMethod() {
		return paymentMethod;
	}

	public Map<String, Integer> getMyOrders() {
		return myOrders;
	}

    
}
