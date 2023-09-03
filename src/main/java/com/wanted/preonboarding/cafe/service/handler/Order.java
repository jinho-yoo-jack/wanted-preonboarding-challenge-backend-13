package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.MENU;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Order {
    private MENU menu;
    private int count;
}
