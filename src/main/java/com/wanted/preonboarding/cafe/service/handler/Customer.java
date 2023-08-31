package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.service.handler.domain.Drink;
import com.wanted.preonboarding.cafe.service.handler.domain.PaymentMethod;
import java.util.Map;
import lombok.Getter;

@Getter
public class Customer {
    private final PaymentMethod paymentMethod;
    private final CafeOrderMenus myOrders;

    public Customer(PaymentMethod paymentMethod, Map<Drink, Integer> menus) {
        this.paymentMethod = paymentMethod;
        this.myOrders = new CafeOrderMenus(menus);
    }

    public CafeOrder buyCoffee(Cashier cashier) {
        return cashier.takeOrder(myOrders);
    }
}
