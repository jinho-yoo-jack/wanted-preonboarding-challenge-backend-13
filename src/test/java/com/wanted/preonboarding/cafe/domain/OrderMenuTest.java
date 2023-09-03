package com.wanted.preonboarding.cafe.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import org.junit.jupiter.api.Test;

class OrderMenuTest {

    @Test
    void createOrderMenu() {
        OrderMenu orderMenu = OrderMenu.from("AMERICANO", 1);

        assertEquals("AMERICANO", orderMenu.menuName());

        assertEquals(4000, orderMenu.menuTotalPrice());
    }

}