package com.wanted.preonboarding.cafe.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Order {
    private Menu menu;
    private int count;
}
