package com.wanted.preonboarding.theater.controller;

import com.wanted.preonboarding.theater.service.TheaterService;
import com.wanted.preonboarding.theater.service.handler.Audience;
import com.wanted.preonboarding.theater.service.handler.Bag;
import com.wanted.preonboarding.theater.service.handler.Invitation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/theater")
@RequiredArgsConstructor
public class TheaterController {
    private final TheaterService theaterService;

    @GetMapping("hello")
    public String welcomeMessage() {
        return "Welcome to The Wanted Theater";
    }

    @PostMapping("enter")
    public String enter(@RequestBody AudienceEnterRequest request) {
        log.info("AudienceEnterRequest: {}", request);
        return theaterService.enter(request.createAudience());
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class AudienceEnterRequest {
        private Long amount;
        private boolean hasInvitation;
        private LocalDateTime invitationDate;

        private Audience createAudience() {
            return new Audience(createBag());
        }

        private Bag createBag() {
            if (isHasInvitation()) {
                return new Bag(new Invitation(getInvitationDate()), getAmount());
            } else {
                return new Bag(getAmount());
            }
        }
    }

}
