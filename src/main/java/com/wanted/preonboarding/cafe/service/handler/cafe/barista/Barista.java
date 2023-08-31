package com.wanted.preonboarding.cafe.service.handler.cafe.barista;

import com.wanted.preonboarding.cafe.service.handler.customer.Order;

import java.util.List;

public interface Barista {

    String makeCoffeeTo(List<Order> receivedOrders);

}
