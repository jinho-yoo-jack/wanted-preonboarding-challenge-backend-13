package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.cafe.service.handler.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TicketSeller {

    private Status status;

    public void startWork() {
        this.status = Status.WORKING;
    }

    public void finishWork() {
        this.status = Status.WAITING;
    }
}
