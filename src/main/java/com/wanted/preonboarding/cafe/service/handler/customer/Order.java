package com.wanted.preonboarding.cafe.service.handler.customer;


import com.wanted.preonboarding.cafe.service.handler.cafe.Menu;
import lombok.Builder;

public class Order {

    private final Menu selectedMenu;
    private final Long quantity;

    @Builder
    public Order(Menu selectedMenu, Long quantity) {
        this.selectedMenu = selectedMenu;
        this.quantity = quantity;
    }

    public Menu getSelectedMenu() {
        return selectedMenu;
    }

    public Long getQuantity() {
        return quantity;
    }
}
