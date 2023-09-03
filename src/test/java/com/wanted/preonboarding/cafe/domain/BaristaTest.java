package com.wanted.preonboarding.cafe.domain;


import com.wanted.preonboarding.cafe.domain.menu.Menu;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BaristaTest {
    @Test
    public void testMakeCoffeeTo() {
        //given
        Barista barista = new Barista(BaristaRank.BEGINNER, BaritaStauts.WAITING);
        List<OrderMenu> orders = new ArrayList<>();
        orders.add(OrderMenu.from(Menu.AMERICANO, 2));
        orders.add(OrderMenu.from(Menu.ESPRESSO, 1));

        //when
        String result = barista.makeCoffeeTo(orders);

        //then
        Assertions.assertThat(result).isEqualTo("Americano:2Espresso:1");
    }
}