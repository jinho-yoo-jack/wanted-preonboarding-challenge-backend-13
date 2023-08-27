package com.wanted.preonboarding.cafe.dto;

import com.wanted.preonboarding.cafe.enums.Menu;
import lombok.Getter;

@Getter
public class OrderRequestParam {
    private Menu menu;
    private int quantity;
}
