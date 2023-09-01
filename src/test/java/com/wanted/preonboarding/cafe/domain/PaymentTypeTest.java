package com.wanted.preonboarding.cafe.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class PaymentTypeTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = { "ABC", "ㄱㄴㄷ", "123" })
    @DisplayName("존재하는 않는 PaymentType 입력시 null")
    void invalidFromInput(String input) {
        //when
        PaymentType result = PaymentType.fromInput(input);

        //then
        assertThat(result).isEqualTo(null);
    }

    @ParameterizedTest
    @ValueSource(strings = { "CARD", "CASH" })
    @DisplayName("존재하는 PaymentType 입력시 성공")
    void fromInputSuccess(String input) {
        //when
        PaymentType result = PaymentType.fromInput(input);

        //then
        assertThat(result).isEqualTo(PaymentType.valueOf(input));
    }
}