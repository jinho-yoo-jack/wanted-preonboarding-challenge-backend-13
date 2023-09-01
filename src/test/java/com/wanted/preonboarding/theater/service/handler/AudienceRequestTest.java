package com.wanted.preonboarding.theater.service.handler;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


class AudienceRequestTest {

    @Test
    public void test_converter_without_invitation() {
        // given
        Long amount = 100L;

        // when
        AudienceRequest request = new AudienceRequest(amount, null);
        Audience audience = request.convert2Audience();

        //then
        assertEquals(audience.getBag().getAmount(), amount);
        assertEquals(audience.hasInvitation(), false);
    }

    @Test
    public void test_converter_with_invitation() {
        // given
        Long amount = 100L;
        InvitationRequest invitationRequest = new InvitationRequest(LocalDateTime.now());

        // when
        AudienceRequest request = new AudienceRequest(amount, invitationRequest);
        Audience audience = request.convert2Audience();

        //then
        assertEquals(audience.getBag().getAmount(), amount);
        assertEquals(audience.hasInvitation(), true);
    }
}