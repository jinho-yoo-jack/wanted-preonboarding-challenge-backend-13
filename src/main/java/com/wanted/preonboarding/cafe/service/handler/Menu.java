package com.wanted.preonboarding.cafe.service.handler;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class Menu {
    private final List<Beverage> beverageList;

    public Menu() {
        this.beverageList = new ArrayList<>();
        beverageList.add(new Beverage("AMERICANO", 3000));
        beverageList.add(new Beverage("ICEDTEA", 2500));
        beverageList.add(new Beverage("COLA", 2000));
    }
}
