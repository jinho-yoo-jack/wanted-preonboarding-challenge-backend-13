package com.wanted.preonboarding.cafe.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum CafeErrorCode {

    NOT_ENOUGH_MONEY(HttpStatus.BAD_REQUEST, "Customer does not have enough money for a beverage"),
    MENU_NOT_FOUND(HttpStatus.NOT_FOUND, "Customer's order menu is not founded"),
    PAYMENT_NOT_ACCEPTABLE(HttpStatus.NOT_FOUND, "Customer's payment is not acceptable this cafe"),
    ALL_CASHIERS_IN_WORK(HttpStatus.NOT_FOUND, "All cashiers in work. Please wait a few minutes"),
    ALL_BARISTAS_IN_WORK(HttpStatus.NOT_FOUND, "All baristas in work. Please wait a few minutes"),
    ORDER_REQUEST_ERROR(HttpStatus.BAD_REQUEST, "Customer's order is not valid"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error occurs"),
    ;

    private final HttpStatus status;
    private final String message;
}
