package com.wanted.preonboarding.cafe.service.handler;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class Cafe {

    private final String name;
    private Long sales;

    private Map<String, Integer> menus;
    private List<Barista> baristas;

    private List<Cashier> cashiers;

    public Cafe(){
        this.name = "wantedCodingCafe";
        this.sales = 10000L;
    }

    public String getCafeName(){
        return name;
    }

    public void plusSales(Long amount){
        this.sales += amount;
    }

    public Map<String, Integer> getMenus(){
        return this.menus;
    }

    public void plusMenu(final String menuName, final Integer menuPrice) {
        this.menus.put(menuName, menuPrice);
    }

    public void minusMenu(final String menuName) {
        this.menus.remove(menuName);
    }

    public void updateMenuPrice(final String menuName, final Integer menuNewPrice) {
        this.menus.replace(menuName, menuNewPrice);
    }

    public void minusSales(Long amount){
        this.sales -= amount;
    }

    public List<Barista> getBaristas(){
        return this.baristas;
    }

    public void plusBaristas(Barista barista) {
        this.baristas.add(barista);
    }

    public List<Cashier> getCashiers(){
        return this.cashiers;
    }

    public void plusCashier(Cashier cashier) {
        this.cashiers.add(cashier);
    }
}
