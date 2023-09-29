package com.wanted.preonboarding.cafe.service.handler;


import com.wanted.preonboarding.cafe.exception.CafeErrorCode;
import com.wanted.preonboarding.cafe.exception.CafeException;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class WantedCafe implements Cafe {
    private final String name;
    private final List<Cashier> cashierList;
    private final List<Barista> baristaList;
    private Long sales;

    public void addCashier(Cashier cashier) {
        cashierList.add(cashier);
    }

    public void addBarista(Barista barista) {
        baristaList.add(barista);
    }

    public List<Cashier> getCashierList() {
        return this.cashierList;
    }

    public List<Barista> getBaristaList() {
        return this.baristaList;
    }

    public String getCafeName(){
        return name;
    }

    public void plusSales(Long amount){
        this.sales += amount;
    }

    public void minusSales(Long amount){
        this.sales -= amount;
    }

    public List<Cashier> createCashiers(int count) {
        List<Cashier> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(new Cashier(this, Status.WAITING));
        }
        return list;
    }

    public Cashier findAvailableCashier() {
        return this.getCashierList().stream()
                .filter(c -> c.getStatus().equals(Status.WAITING))
                .findAny()
                .orElseThrow(() -> new CafeException(CafeErrorCode.ALL_CASHIERS_IN_WORK));
    }

    public List<Barista> createBaristas(int count) {
        Rank[] ranks = Rank.values();
        List<Barista> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(new Barista(this, ranks[i % ranks.length], Status.WAITING));
        }
        return list;
    }

    public Barista findAvailableBarista() {
        return this.getBaristaList().stream()
                .filter(b -> b.getStatus() == Status.WAITING)
                .findAny()
                .orElseThrow(() -> new CafeException(CafeErrorCode.ALL_BARISTAS_IN_WORK));
    }
}
