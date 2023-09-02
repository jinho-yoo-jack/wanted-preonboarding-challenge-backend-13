package com.wanted.preonboarding.theater.service.handler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Audience {
    private Bag bag;

    public boolean hasInvitation() {
        return this.bag.getInvitation() != null;
    }
}
