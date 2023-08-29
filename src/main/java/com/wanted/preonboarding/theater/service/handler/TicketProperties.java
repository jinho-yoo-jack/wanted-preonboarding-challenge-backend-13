package com.wanted.preonboarding.theater.service.handler;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "ticket")
public class TicketProperties {
    private long fee;

    public void setFee(String fee) {
        this.fee = Long.parseLong(fee);
    }

    public long getFee() {
        return fee;
    }
}
