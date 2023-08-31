package com.wanted.preonboarding.cafe.service.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class Barista {
    private int rank; // 0: Beginner 1: Middle 2: Master
    private int status; // 0: Waiting 1: Making

    /**
     * 주문을 받아서 커피를 만드는 메소드
     * @param orders 주문
     * @return 커피 제조 결과
     */
    public String makeCoffeeTo(Map<String, Integer> orders){
        status = 1;

        StringBuilder makeOrders = new StringBuilder();
        for(String coffeeName : orders.keySet()){
            int quantity = orders.get(coffeeName);
            makeOrders.append(coffeeName)
                    .append(":")
                    .append(quantity)
                    .append("\n");
        }

        status = 0;
        return makeOrders.toString();
    }
}
