package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.service.Menu;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    private String paymentMethod;
    public Customer(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    private void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

}
