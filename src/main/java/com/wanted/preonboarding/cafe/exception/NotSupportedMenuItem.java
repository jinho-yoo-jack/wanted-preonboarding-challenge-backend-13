package com.wanted.preonboarding.cafe.exception;

public class NotSupportedMenuItem extends RuntimeException {
    String requestedMenu;

    public NotSupportedMenuItem(String requestedMenu) {
        super(String.format("%s is not supported menu", requestedMenu));
        this.requestedMenu = requestedMenu;
    }
}
