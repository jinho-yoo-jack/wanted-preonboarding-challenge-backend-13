package com.wanted.preonboarding.theater.vo;

import com.wanted.preonboarding.theater.service.handler.Audience;
import com.wanted.preonboarding.theater.service.handler.Bag;
import com.wanted.preonboarding.theater.service.handler.Invitation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class RequestMessage {

    private static final String WHEN_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private Long amount;

    @DateTimeFormat(pattern = WHEN_PATTERN)
    private LocalDateTime when;

    public boolean hasInvitation() {
        return this.when != null;
    }

    public Audience toAudience() {
        Invitation invitation = this.hasInvitation()
                ? new Invitation(this.when)
                : null
                ;
        Bag bag = new Bag(invitation, this.amount);
        return new Audience(bag);
    }
}
