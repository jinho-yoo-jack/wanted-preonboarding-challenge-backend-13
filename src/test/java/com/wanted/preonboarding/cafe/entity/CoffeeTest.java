package com.wanted.preonboarding.cafe.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CoffeeTest {

    @Test
    @DisplayName("아메리카노 이름에 해당하는 Coffee를 찾는다.")
    void findAmericano() {
        // given
        String name = Coffee.AMERICANO.getName();

        // when
        Coffee coffee = Coffee.findByName(name);

        // then
        assertThat(coffee).isEqualTo(Coffee.AMERICANO);
    }
}