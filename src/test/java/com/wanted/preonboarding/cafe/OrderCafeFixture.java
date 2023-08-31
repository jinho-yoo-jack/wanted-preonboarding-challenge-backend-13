package com.wanted.preonboarding.cafe;

import com.wanted.preonboarding.cafe.dto.request.OrderCustomerRequest;
import com.wanted.preonboarding.cafe.service.handler.cafe.Menu;
import com.wanted.preonboarding.cafe.service.handler.customer.Order;
import com.wanted.preonboarding.cafe.service.handler.customer.PaymentMethodType;

import java.util.ArrayList;
import java.util.List;

public class OrderCafeFixture {

    public static final OrderCustomerRequest SUCCESS_ORDER_REQUEST = OrderCustomerRequest.builder()
            .paymentMethodType(PaymentMethodType.CARD)
            .orders(makeOrdersForTest())
            .build();

    private static List<Order> makeOrdersForTest() {
        List<Order> orders = new ArrayList<>();

        Order order1 = Order.builder()
                .selectedMenu(Menu.AMERICANO)
                .quantity(3L)
                .build();

        Order order2 = Order.builder()
                .selectedMenu(Menu.ESPRESSO)
                .quantity(2L)
                .build();

        Order order3 = Order.builder()
                .selectedMenu(Menu.LATTE)
                .quantity(1L)
                .build();

        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        return orders;
    }
}
