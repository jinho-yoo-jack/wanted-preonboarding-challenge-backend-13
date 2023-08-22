package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.dto.BeverageOrder;
import lombok.Getter;
import lombok.ToString;

import static java.lang.String.*;

@ToString
public class Order {

    @Getter
    private final Beverage beverage;

    private final long quantity;

    private Order(Beverage beverage, long quantity) {
        this.beverage = beverage;
        this.quantity = quantity;
    }

    public static Order ofRequest(BeverageOrder.OrderInfo request) {

        Beverage type = Beverage.valueOf(request.getName());
        return new Order(type, request.getQuantity());
    }

    public long getBeveragePrice() {

        return beverage.getPrice() * quantity;
    }

    public String printOrder() {

        return format("%s:%s", beverage.name(), quantity);
    }

}
