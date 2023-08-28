package com.wanted.preonboarding.cafe.entity;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Orders {
    private final List<Order> orderList = new ArrayList<>();
}
