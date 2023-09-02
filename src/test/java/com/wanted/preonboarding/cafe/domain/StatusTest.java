package com.wanted.preonboarding.cafe.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StatusTest {
    @Test
    @DisplayName("지금 만들고 있는 상태인지 확인")
    void isBusy() {
        //given
        final Status status = Status.MAKING;

        //when
        boolean result = status.isMaking();

        //then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("지금 만들지 않고 있는 상태인지 확인")
    void isNotBusy() {
        //given
        final Status status = Status.WAITING;

        //when
        boolean result = status.isMaking();

        //then
        assertThat(result).isFalse();
    }
}