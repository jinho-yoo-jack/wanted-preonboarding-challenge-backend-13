package com.wanted.preonboarding.theater.service.handler;

import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AudienceRequest {
    private Bag bag;
}
