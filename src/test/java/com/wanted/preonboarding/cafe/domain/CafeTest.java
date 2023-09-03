package com.wanted.preonboarding.cafe.domain;

import com.wanted.preonboarding.cafe.domain.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CafeTest {
    private Cashier mockCashier;
    private Barista mockBarista;
    private Cafe cafe;

    @BeforeEach
    public void setUp() {
        mockCashier = mock(Cashier.class);
        mockBarista = mock(Barista.class);
        cafe = new Cafe(mockCashier, mockBarista);
    }

    @Test
    public void testTakeOrderAndUpdateSales() {
        List<OrderMenu> orders = new ArrayList<>();
        orders.add(OrderMenu.from(Menu.LATTE, 2));
        orders.add(OrderMenu.from(Menu.ESPRESSO, 1));

        when(mockCashier.calculateTotalPrice(orders)).thenReturn(1200L);

        cafe.takeOrder(orders);

        assertEquals(11200L, cafe.getSales());
    }

    @Test
    public void testSendToBarista() {
        List<OrderMenu> orders = new ArrayList<>();
        orders.add(OrderMenu.from(Menu.LATTE, 2));
        orders.add(OrderMenu.from(Menu.ESPRESSO, 1));

        when(mockBarista.makeCoffeeTo(orders)).thenReturn("Latte:2Espresso:1");

        String result = cafe.sendTo(orders);

        assertEquals("Latte:2Espresso:1", result);
    }

}