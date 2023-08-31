package com.wanted.preonboarding.cafe.dto;

import com.wanted.preonboarding.cafe.service.handler.Menu;
import com.wanted.preonboarding.cafe.service.handler.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class OrderRequest {
    private List<MenuDto> menus;
    private PaymentMethod paymentMethod;

    @Getter @Setter
    public static class MenuDto {
        private Menu menu;
        private int count;
    }
}
