package com.wanted.preonboarding.cafe.service.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class Cafe {
    private final String name;
    private List<Order> sales;
    private List<Cashier> cashierList;
    private List<Barista> baristaList;

    public Cafe() {
        this.name = "wantedCodingCafe";
        this.sales = new ArrayList<>();
        this.cashierList = List.of(new Cashier(Status.WAITING, this));
        this.baristaList = List.of(new Barista(Rank.BEGINNER, Status.WAITING));
    }


    public void plusSales(Order order) {
        this.sales.add(order);
    }

    public Cashier getWaitingCashier() {
        for (Cashier cashier : cashierList) {
            if (cashier.isWaiting()) {
                return cashier;
            }
        }
        throw new RuntimeException("모든 점원이 계산중입니다. 다음에 다시 시도해주세요.");
    }

    public Barista getWaitingBarista() {
        int count = 0;
        while (true) {
            int index = count % baristaList.size();
            Barista barista = baristaList.get(index);
            if (barista.isWaiting()) {
                barista.updateWorkingStatus(Status.WORKING);
                return barista;
            } else {
                count++;
            }
        }
    }
}
