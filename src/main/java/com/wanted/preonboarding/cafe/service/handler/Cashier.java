package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.MENU;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Cashier {
    private Long sales;

    public Cashier() {
        this.sales = 10000L;
    }
    /** 주문 금액 계산 */
    public long calculateTotalPrice(OrderRequest orderRequest){
        long sum = 0;
        for (Order order : orderRequest.getOrderList()) {
            int count = order.getCount();
            MENU menu = order.getMenu();
            int price = menu.getPrice();
            sum += price * count;
        }
        log.error("주문 총액 [{}]", sum);
        return sum;
    }

    void plusSales(Long amount){
        this.sales += amount;
    }

    void minusSales(Long amount){
        this.sales -= amount;
    }


}
