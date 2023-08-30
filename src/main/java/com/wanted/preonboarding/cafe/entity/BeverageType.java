package com.wanted.preonboarding.cafe.entity;

import com.wanted.preonboarding.cafe.exception.MenuOrderException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum BeverageType {
    AMERICANO(100L),
    CAFFELATTE(120L),
    MATCHALATTE(200L),
    ESPRESSO(100L);

    private final Long price;

    public static BeverageType getBeverageTypeByInputName(String inputValue) throws MenuOrderException {
        return Stream.of(BeverageType.values())
                .filter(item -> item.toString().equals(inputValue.toUpperCase()))
                .findFirst()
                .orElseThrow(()->new MenuOrderException(
                        HttpStatus.BAD_REQUEST,
                        "해당 음료는 메뉴에 없는 음료입니다."
                        ));
    }
}