package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.service.handler.domain.BaristaRank;
import com.wanted.preonboarding.cafe.service.handler.domain.MakingStatus;
import java.util.List;
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

    public List<CafeOrderItem> makeDrink(CafeOrderMenus cafeOrderMenus) {
        return cafeOrderMenus.getMenus().keySet()
                .stream()
                .map(drink -> CafeOrderItem.makeSuccess(drink, cafeOrderMenus.getQuantityOf(drink)))
                .toList();
    }
}
