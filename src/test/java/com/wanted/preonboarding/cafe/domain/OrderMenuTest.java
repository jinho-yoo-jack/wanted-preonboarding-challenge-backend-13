package com.wanted.preonboarding.cafe.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderMenuTest {

    @Test
    void createOrderMenu() {
        OrderMenu orderMenu = OrderMenu.from("AMERICANO", 1);

        assertEquals("AMERICANO", orderMenu.menuName());

        assertEquals(4000, orderMenu.menuTotalPrice());
    }

}