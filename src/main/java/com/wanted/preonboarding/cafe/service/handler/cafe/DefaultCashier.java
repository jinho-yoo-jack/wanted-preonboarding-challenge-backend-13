package com.wanted.preonboarding.cafe.service.handler.cafe;

import com.wanted.preonboarding.cafe.service.handler.cafe.barista.Rank;
import com.wanted.preonboarding.cafe.service.handler.cafe.barista.Status;
import com.wanted.preonboarding.cafe.service.handler.customer.Customer;
import com.wanted.preonboarding.cafe.service.handler.customer.Order;
import com.wanted.preonboarding.cafe.service.handler.cafe.barista.DefaultBarista;

import java.util.List;

public class DefaultCashier implements Cashier{

    private final PosMachine posMachine;

    public DefaultCashier(PosMachine posMachine) {
        this.posMachine = posMachine;
    }

    private String sendTo(DefaultBarista barista, List<Order> receivedOrders) {
        return barista.makeCoffeeTo(receivedOrders);
    }

    @Override
    public String takeOrder(Customer customer) {
        long totalPrice = posMachine.calculateTotalPrice(customer.getMyOrders());
        posMachine.pay(totalPrice, customer.getPaymentMethod());
        return sendTo(new DefaultBarista(Rank.BEGINNER, Status.WAITING), customer.getMyOrders());
    }
}
