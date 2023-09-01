package com.wanted.preonboarding.cafe.dto;

import com.wanted.preonboarding.cafe.domain.Menu;
import com.wanted.preonboarding.cafe.domain.Order;
import com.wanted.preonboarding.cafe.domain.PaymentType;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

class OrderRequestTest {

    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeAll
    public static void init() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }
    @ParameterizedTest
    @ValueSource(strings = "QR_CODE")
    @NullAndEmptySource
    @DisplayName("존재하지 않는 paymentType 입력 시 오류")
    void invalidPaymentType(String paymentType) {
        //given & when
        OrderRequest orderRequest = new OrderRequest(PaymentType.fromInput(paymentType), List.of(new Order(Menu.AMERICANO, 1)));

        Set<ConstraintViolation<OrderRequest>> violations = validator.validate(orderRequest);
        ConstraintViolation<OrderRequest> result = violations.iterator().next();

        //then
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(violations).size().isNotZero();
            softAssertions.assertThat(result.getPropertyPath().toString()).isEqualTo("paymentType");
        });
    }

    @Test
    @DisplayName("주문은 1건 이상이 아니면 실패")
    void invalidSizeOrder() {
        //given & then
        OrderRequest orderRequest = new OrderRequest(PaymentType.CARD, new ArrayList<>());

        Set<ConstraintViolation<OrderRequest>> violations = validator.validate(orderRequest);
        ConstraintViolation<OrderRequest> result = violations.iterator().next();

        //then
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(violations).size().isNotZero();
            softAssertions.assertThat(result.getPropertyPath().toString()).isEqualTo("order");
        });
    }

    @Test
    @DisplayName("유효성 검증에 통과한 주문")
    void validOrderRequest() {
        //given
        final PaymentType paymentType = PaymentType.CASH;
        final Order order = new Order(Menu.AMERICANO, 2);

        //when
        OrderRequest orderRequest = new OrderRequest(paymentType, List.of(order));

        //then
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(orderRequest.getPaymentType()).isEqualTo(paymentType);
            softAssertions.assertThat(orderRequest.getOrder().get(0)).isEqualTo(order);
        });
    }
}