package com.wanted.preonboarding.cafe.service.handler;


import java.util.Collections;
import java.util.Map;

public class Beverage {
    private final String menuName;
    private final long price;
    private final Map<String, Long> extraRecipe;

    public Beverage(String m, long p, Map<String, Long> r) {
        this.menuName = m;
        this.price = p;
        this.extraRecipe = r;
    }

    public String getMenuName(){
        return menuName;
    }

    public Beverage(String m, long p) {
        this(m, p, Collections.emptyMap());
    }

    public long calculatePrice() {
        long extraRecipeTotalAmount = 0L;
        if (!extraRecipe.isEmpty()) {
            for (String extraMenu : extraRecipe.keySet()) {
                extraRecipeTotalAmount += extraRecipe.get(extraMenu);
            }
        }
        return getPrice() + extraRecipeTotalAmount;
    }

    private long getPrice() {
        return this.price;
    }


}
