package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.service.handler.domain.BaristaRank;
import com.wanted.preonboarding.cafe.service.handler.domain.Drink;
import com.wanted.preonboarding.cafe.service.handler.domain.MakingStatus;
import java.util.List;
import java.util.Map;
import lombok.Getter;

@Getter
public class Barista {
    private BaristaRank rank; // 0: Beginner 1: Middle 2: Master
    private MakingStatus status; // 0: Waiting 1: Making

    public Barista() {
        this(BaristaRank.BEGINNER, MakingStatus.WAIT);
    }

    public Barista(BaristaRank rank, MakingStatus status) {
        this.rank = rank;
        this.status = status;
    }

    public List<CafeOrderItem> makeDrink(Map<Drink, Integer> orders) {
        return orders.keySet()
                .stream()
                .map(drink -> new CafeOrderItem(drink, orders.get(drink), true))
                .toList();
    }
}
