package com.wanted.preonboarding.cafe.service.handler;

import java.util.HashMap;
import java.util.Map;

public class MenuBoard {

    private static Map<String, Integer> menus;

    public MenuBoard() {
        menus = new HashMap<>();
        menus.put("AMERICANO", 4000);
        menus.put("CAFE_LATTE", 5000);
        menus.put("ESPRESSO", 3000);
    }

    public static boolean hasMenu(String name){
        return menus.containsKey(name);
    }

    public static int getPrice(String name){
        return menus.get(name);
    }

}
