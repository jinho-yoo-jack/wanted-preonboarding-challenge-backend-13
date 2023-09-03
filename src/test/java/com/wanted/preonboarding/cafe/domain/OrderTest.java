package com.wanted.preonboarding.cafe.domain;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

class OrderTest {
    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeAll
    public static void init() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = "CHOCO_MANGO")
    @DisplayName("유효하지 않는 메뉴 입력시 오류")
    void invalidMenu(String param) {
        //given & when
        final Order order = new Order(Menu.fromInput(param), 1);

        Set<ConstraintViolation<Order>> violations = validator.validate(order);
        ConstraintViolation<Order> result = violations.iterator().next();

        //then
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(violations).size().isNotZero();
            softAssertions.assertThat(result.getPropertyPath().toString()).isEqualTo("menu");
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("최소 갯수보다 적게 입력시 오류")
    void invalidCount(int count)  {
        //given & then
        final Order order = new Order(Menu.AMERICANO, count);

        Set<ConstraintViolation<Order>> violations = validator.validate(order);
        ConstraintViolation<Order> result = violations.iterator().next();

        //then
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(violations).size().isNotZero();
            softAssertions.assertThat(result.getPropertyPath().toString()).isEqualTo("count");
        });
    }

    @Test
    @DisplayName("정상적으로 메뉴 생성")
    void validMenu() {
        //given
        final Menu menu = Menu.AMERICANO;
        final int count = 1;

        //when
        final Order order = new Order(menu, count);

        //then
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(order.getMenu()).isEqualTo(menu);
            softAssertions.assertThat(order.getCount()).isEqualTo(count);
        });
    }
}
