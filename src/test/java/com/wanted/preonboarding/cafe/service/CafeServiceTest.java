package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.service.handler.Cashier;
import com.wanted.preonboarding.cafe.service.handler.Customer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CafeServiceTest {
    @Autowired
    private Cashier cashier;

    @Test
    @DisplayName("주문 가능한 갯수 주문 테스트")
    public void possibilityOrderFromTest() {
        Map<String, Long> orders = new HashMap<>();
        orders.put("AMERICANO", 3L);
        orders.put("TEA", 5L);

        Customer customer = new Customer(orders);
        String result = cashier.takeOrder(customer.getMyOrders());

        assertNotNull(result);
    }

    @Test
    @DisplayName("주문 불가능한 갯수 주문 테스트")
    public void impossibilityOrderFromTest() {
        Map<String, Long> orders = new HashMap<>();
        orders.put("AMERICANO", 3L);
        orders.put("TEA", 5L);
        orders.put("JUICE", 7L);
        orders.put("ADE", 15L);

        Customer customer = new Customer(orders);
        String result = cashier.takeOrder(customer.getMyOrders());

        assertNull(result);
    }
}
