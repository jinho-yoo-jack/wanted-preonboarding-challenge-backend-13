package com.wanted.preonboarding.theater.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class AudienceInfo {

    private BagInfo bag;

    @Getter
    public static class BagInfo {

        private long amount;

        private InvitationInfo invitation;

        private TicketInfo ticket;

        @Getter
        public static class InvitationInfo {

            private LocalDateTime when;
        }

        @Getter
        public static class TicketInfo {

            private long fee;
        }

    }


}
