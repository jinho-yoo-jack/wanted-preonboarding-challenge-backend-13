package com.wanted.preonboarding.cafe.service.handler;

import static org.assertj.core.api.Assertions.*;

import com.wanted.preonboarding.cafe.service.handler.domain.BaristaRank;
import com.wanted.preonboarding.cafe.service.handler.domain.Drink;
import com.wanted.preonboarding.cafe.service.handler.domain.MakingStatus;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaristaTest {

    @Test
    @DisplayName("전달받은 주문의 음료를 제조한다.")
    void make_ordered_drink() {
        // given
        Map<Drink, Integer> menus = new HashMap<>();
        menus.put(Drink.AMERICANO, 3);
        menus.put(Drink.LATTE, 5);

        Barista barista = new Barista(BaristaRank.MIDDLE, MakingStatus.MAKING);

        // when
        List<CafeOrderItem> madeDrinks = barista.makeDrink(menus);

        // then
        assertThat(barista.getRank()).isEqualTo(BaristaRank.MIDDLE);
        assertThat(barista.getStatus()).isEqualTo(MakingStatus.MAKING);

        assertThat(madeDrinks).hasSize(2)
                .extracting("drink", "quantity", "isMade")
                .containsExactly(
                        tuple(Drink.AMERICANO, 3, true),
                        tuple(Drink.LATTE, 5, true)
                );
    }

}