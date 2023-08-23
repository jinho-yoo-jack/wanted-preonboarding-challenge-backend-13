package com.wanted.preonboarding.cafe.service.handler;

import java.util.List;

public interface Cafe {

    void addCashier(Cashier cashier);

    void addBarista(Barista barista);

    public List<Cashier> getCashierList();

    public List<Barista> getBaristaList();

    String getCafeName();

    void plusSales(Long amount);

    void minusSales(Long amount);

}
