package com.wanted.preonboarding.cafe.dto;

import com.wanted.preonboarding.cafe.entity.Drinks;
import com.wanted.preonboarding.cafe.entity.Order;
import com.wanted.preonboarding.cafe.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Setter
public class OrdersReqDto {

    private List<OrderReqDto> orderList;

    public Orders toEntity() {
        Orders orders = new Orders();

        for (OrderReqDto o :
            orderList) {
            Order order = o.toEntity(
                switch (o.getDrinks()) {
                    case "AMERICANO" -> Drinks.AMERICANO;
                    case "CAPPUCCINO" -> Drinks.CAPPUCCINO;
                    case "CAFFE_LATTE" -> Drinks.CAFFE_LATTE;
                    default -> throw new IllegalStateException("Unexpected value: " + o.getDrinks());
                }
            );
            orders.getOrderList().add(order);
        }
        return orders;
    }
}
