package com.wanted.preonboarding.cafe.cafe.service.dto;

import java.util.List;

public class OrderRequest {
    private List<OrderItem> menuList;
    private long customerId;

    public List<OrderItem> getMenuList() {
        return menuList;
    }

    public long getCustomerId() {
        return customerId;
    }


}
