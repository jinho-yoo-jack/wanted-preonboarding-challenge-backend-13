package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.service.handler.domain.BaristaRank;
import com.wanted.preonboarding.cafe.service.handler.domain.BaristaStatus;
import com.wanted.preonboarding.cafe.service.handler.domain.Menu;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
public class Barista {
    private BaristaRank rank; // 0: Beginner 1: Middle 2: Master
    private BaristaStatus status; // 0: Waiting 1: Making

    public Barista() {
        this(BaristaRank.BEGINNER, BaristaStatus.WAITING);
    }

    public Barista(BaristaRank rank, BaristaStatus status) {
        this.rank = rank;
        this.status = status;
    }

    public List<CafeOrderItem> makeDrink(CafeOrderMenus cafeOrderMenus) {
        return cafeOrderMenus.getMenus().keySet()
                .stream()
                .map(drink -> CafeOrderItem.makeSuccess(drink, cafeOrderMenus.getQuantityOf(drink)))
                .toList();

    }
}
