package com.wanted.preonboarding.cafe.service.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
@AllArgsConstructor
@Slf4j
public class Barista {
    @Getter
    @Setter private int rank; // 0: Beginner 1: Middle 2: Master
    @Setter private int status; // 0: Waiting 1: Making

    public String makeCoffeeTo(OrderRequest orderRequest){
        this.status = 1;
        StringBuilder makeOrders = new StringBuilder();
        List<Order> orderList = orderRequest.getOrderList();

        for(Order order : orderList){
            int quantity = order.getCount();
            String coffeeName = order.getMenu()
                                     .name();
            makeOrders.append(coffeeName)
                    .append(":")
                    .append(quantity);
        }
        this.status = 0;
        return makeOrders.toString();
    }

    /** 커피를 만들 수 있는지에 대한 확인 */
    public boolean canMakeCoffee() {
        log.error("바리스타 상태[{}]", status);
        return status == 0;
    }

}
