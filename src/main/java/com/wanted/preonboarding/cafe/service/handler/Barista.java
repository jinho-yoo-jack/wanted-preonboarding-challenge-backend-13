package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.domain.Order;
import com.wanted.preonboarding.cafe.domain.Rank;
import com.wanted.preonboarding.cafe.domain.Status;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Barista {
    private Rank rank;
    private Status status;

    /**
     * 커피를 제조합니다.
     */
    public String makeCoffeeTo(List<Order> orders){
        this.status = Status.MAKING;

        StringBuilder makeOrders = new StringBuilder();
        orders.forEach(order -> {
            makeOrders.append(order.getMenu())
                .append(":")
                .append(order.getCount());
        });

        this.status = Status.WAITING;

        return makeOrders.toString();
    }

    /**
     * 바리스타의 현재 상태를 확인합니다.
     */
    public boolean isBusy() {
        return this.status.isMaking();
    }
}
