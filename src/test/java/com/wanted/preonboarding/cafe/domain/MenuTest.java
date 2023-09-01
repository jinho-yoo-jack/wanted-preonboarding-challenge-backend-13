package com.wanted.preonboarding.cafe.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class MenuTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = { "ABC", "ㄱㄴㄷ", "123" })
    @DisplayName("존재하는 않는 Menu 입력시 null")
    void invalidFromInput(String input) {
        //when
        Menu result = Menu.fromInput(input);

        //then
        assertThat(result).isEqualTo(null);
    }

    @ParameterizedTest
    @ValueSource(strings = { "AMERICANO", "CAFE_LATTE", "ICE_CHOCO", "ICE_MANGO" })
    @DisplayName("존재하는 Menu 입력시 성공")
    void fromInputSuccess(String input) {
        //when
        Menu result = Menu.fromInput(input);

        //then
        assertThat(result).isEqualTo(Menu.valueOf(input));
    }
}