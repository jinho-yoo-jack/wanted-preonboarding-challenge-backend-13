package com.wanted.preonboarding.cafe.service.handler;

import java.util.List;

public interface Cafe {

    void plusSales(Long amount);

    void minusSales(Long amount);

    void addCashier(Cashier cashier);

    void addBarista(Barista barista);

    List<Cashier> getCashierList();

    List<Barista> getBaristaList();

    String getCafeName();

    List<Cashier> createCashiers(int count);

    Cashier findAvailableCashier();

    List<Barista> createBaristas(int count);

    Barista findAvailableBarista();

}
