package com.wanted.preonboarding.theater.service.handler;

import lombok.*;

@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@ToString
public class Ticket {
    private Long fee;
}
