    package com.wanted.preonboarding.theater.exception;

    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import org.springframework.http.HttpStatus;

    @Getter
    @AllArgsConstructor
    public enum TheaterErrorCode {

        NOT_ENOUGH_MONEY(HttpStatus.BAD_REQUEST, "Audience does not have enough money for a ticket"),
        NOT_FOUND_TICKET(HttpStatus.NOT_FOUND, "Audience does not have any ticket"),
        TICKET_SOLD_OUT(HttpStatus.INTERNAL_SERVER_ERROR, "Ticket sold out"),
        NOT_FOUND_INVITATION(HttpStatus.NOT_FOUND, "Invitation is not founded"),
        INVITATION_ALREADY_USED(HttpStatus.CONFLICT, "Invitation is already used"),
        INVITATION_EXPIRED(HttpStatus.BAD_REQUEST, "Invitation is already expired"),
        INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error occurs"),
        ;

        private final HttpStatus status;
        private final String message;
    }
