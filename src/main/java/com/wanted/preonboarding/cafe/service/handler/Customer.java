package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.service.handler.domain.Menu;
import com.wanted.preonboarding.cafe.service.handler.domain.PaymentMethod;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    private final PaymentMethod paymentMethod;
    private final CafeOrderMenus myOrders;

    public Customer(PaymentMethod paymentMethod, Map<Menu, Integer> menus) {
        this.paymentMethod = paymentMethod;
        this.myOrders = new CafeOrderMenus(menus);
    }


    public CafeOrder buyCoffee(Cashier cashier) {
        return cashier.takeOrder(myOrders);
    }
}
