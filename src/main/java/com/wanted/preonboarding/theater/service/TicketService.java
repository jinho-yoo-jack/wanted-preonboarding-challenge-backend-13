package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.audience.enums.AdmissionType;
import com.wanted.preonboarding.audience.service.handler.Audience;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TicketService {

    public static AdmissionType canEnter(Audience audience) {
        if (!audience.getBag().hasValidInvitation(LocalDateTime.now())) {
            return AdmissionType.DENIED;
        }

        if (!audience.getBag().hasTicket()) {
            return AdmissionType.DENIED;
        }

        return AdmissionType.ENTER;
    }
}
