package com.wanted.preonboarding.cafe.domain;

import static org.junit.jupiter.api.Assertions.*;

import com.wanted.preonboarding.cafe.domain.menu.Americano;
import com.wanted.preonboarding.cafe.domain.menu.CafeMenu;
import com.wanted.preonboarding.cafe.domain.menu.CafeMenuFactory;
import com.wanted.preonboarding.cafe.domain.menu.Espresso;
import com.wanted.preonboarding.cafe.domain.menu.Latte;
import com.wanted.preonboarding.cafe.domain.menu.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CafeMenuFactoryTest {

    @Test
    @DisplayName("아메리카노를 생성하면 아메리카노 객체를 반환한다.")
    public void testCreateCafeMenuForAmericano() {
        CafeMenu americano = CafeMenuFactory.createCafeMenu(Menu.AMERICANO);
        assertEquals(americano.getClass(), Americano.class);
    }

    @Test
    @DisplayName("에스프레소를 생성하면 에스프레소 객체를 반환한다.")
    public void testCreateCafeMenuForEspresso() {
        CafeMenu espresso = CafeMenuFactory.createCafeMenu(Menu.ESPRESSO);
        assertEquals(espresso.getClass(), Espresso.class);
    }

    @Test
    @DisplayName("라떼를 생성하면 라떼 객체를 반환한다.")
    public void testCreateCafeMenuForLatte() {
        CafeMenu latte = CafeMenuFactory.createCafeMenu(Menu.LATTE);
        assertEquals(latte.getClass(), Latte.class);
    }

    @Test
    @DisplayName("존재하지 않는 메뉴를 생성하면 예외가 발생한다.")
    void createNotExistMenu() {
        assertThrows(IllegalArgumentException.class, () -> CafeMenuFactory.createCafeMenu(null));
    }

}