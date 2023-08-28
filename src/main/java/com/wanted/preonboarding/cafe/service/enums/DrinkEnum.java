package com.wanted.preonboarding.cafe.service.enums;


public enum DrinkEnum {
    COFFEE("Coffee", 3L),
    TEA("Tea", 2L),
    SMOOTHIE("Smoothie", 4L);
    // SODA("Soda", 1.50),
    // WATER("Water", 1.00);

    private final String name;
    private final Long price;

    DrinkEnum(String name, Long price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    public static Long getPriceByName(String name) {
        for (DrinkEnum drink : values()) {
            if (drink.getName().equalsIgnoreCase(name)) {
                return drink.getPrice();
            }
        }
        return null; // 해당 이름에 대한 가격이 없을 경우 처리
    }
}