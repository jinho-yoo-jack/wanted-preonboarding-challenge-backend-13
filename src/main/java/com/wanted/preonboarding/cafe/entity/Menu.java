package com.wanted.preonboarding.cafe.entity;


import lombok.Getter;

@Getter
public enum Menu {

    AMERICANO(1000), LATTE(1500), SMOOTHIE(2000)
    ;
    private Integer price;

    Menu(Integer price) {
        this.price = price;
    }

    public static Integer getPriceByKey(String key) {
        for (Menu menu : Menu.values()) {
            if (menu.name().equalsIgnoreCase(key)) {
                return menu.getPrice();
            }
        }
        return 0; // 메뉴가 없을 경우 처리
    }

}
