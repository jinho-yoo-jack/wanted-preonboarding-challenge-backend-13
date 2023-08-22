package com.wanted.preonboarding.cafe.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class BeverageOrder {

    private List<OrderInfo> orders;

    @Getter
    public static class OrderInfo {

        private String name;

        private long quantity;
    }

}
