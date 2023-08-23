package com.wanted.preonboarding.cafe.service.handler;


import java.util.ArrayList;
import java.util.List;

public class WantedCafe implements Cafe {
    private final String name;
    private Long sales;
    private final List<Cashier> cashierList;
    private final List<Barista> baristaList;

    public WantedCafe(String name, Long sales, List<Cashier> cashierList, List<Barista> baristaList){
        this.name = name;
        this.sales = sales;
        this.cashierList = cashierList;
        this.baristaList = baristaList;
    }

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
}
