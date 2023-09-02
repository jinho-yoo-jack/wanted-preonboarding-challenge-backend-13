package com.wanted.preonboarding.cafe.service.handler;

import lombok.Builder;

import java.util.Map;

@Builder
public class Barista {
    private int rank;
    private int status;

    public Barista(int rank, int status) {
        this.rank = rank;
        this.status = status;
    }

    public String makeCoffeeTo(Map<String, Long> menus) {
        StringBuilder makeMenus = new StringBuilder();

        for (String menu : menus.keySet()) {
            long quantity = menus.get(menu);
            makeMenus.append(menu)
                    .append(":")
                    .append(quantity);
        }

        return makeMenus.toString();
    }
}
