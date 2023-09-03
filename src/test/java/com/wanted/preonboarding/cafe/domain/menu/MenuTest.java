package com.wanted.preonboarding.cafe.domain.menu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MenuTest {
    @Test
    @DisplayName("메뉴를 찾는다.")
    void findMenu() {
        Menu menu = Menu.of("Americano");

        assertEquals(Menu.AMERICANO, menu);
    }

    @Test
    @DisplayName("메뉴를 찾지 못한다.")
    void findMenuFail() {
        assertThrows(IllegalArgumentException.class, () -> Menu.of("Aamericano"));
    }
}