package com.wanted.preonboarding.theater.service.handler;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MoneyTest {

    @Test
    void plus() {
        Money money = new Money(100L);
        Money money1 = new Money(100L);
        Money plus = money.plus(money1);
        assertEquals(new Money(200L), plus);
    }

    @Test
    void minus() {
        Money money = new Money(100L);
        Money money1 = new Money(100L);
        Money minus = money.minus(money1);
        assertEquals(new Money(0L), minus);
    }

    @Test
    void if_negative_throw_exception() {
       assertThrows(IllegalArgumentException.class, () -> new Money(-100L));
    }

}