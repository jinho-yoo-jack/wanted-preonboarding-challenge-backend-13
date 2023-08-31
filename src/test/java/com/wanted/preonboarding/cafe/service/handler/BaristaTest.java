package com.wanted.preonboarding.cafe.service.handler;
import static org.assertj.core.api.Assertions.*;

import com.wanted.preonboarding.cafe.service.handler.domain.BaristaRank;
import com.wanted.preonboarding.cafe.service.handler.domain.BaristaStatus;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wanted.preonboarding.cafe.service.handler.domain.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaristaTest {

    @Test
    @DisplayName("전달받은 주문의 음료를 제조한다.")
    void make_ordered_drink() {
        // given
        Map<Menu, Integer> menus = new HashMap<>();
        menus.put(Menu.AMERICANO, 3);
        menus.put(Menu.LATTE, 5);

        Barista barista = new Barista(BaristaRank.MIDDLE, BaristaStatus.MAKING);

        // when
        CafeOrderMenus orders = new CafeOrderMenus(menus);
        List<CafeOrderItem> madeDrinks = barista.makeDrink(orders);
        // then
        assertThat(barista.getRank()).isEqualTo(BaristaRank.MIDDLE);
        assertThat(barista.getStatus()).isEqualTo(BaristaStatus.MAKING);

        assertThat(madeDrinks).hasSize(2)
                .extracting("menu", "quantity", "isMade")
                .containsAnyOf(
                        tuple(Menu.AMERICANO, 3, true),
                        tuple(Menu.LATTE, 5, true)
                );
    }
}
