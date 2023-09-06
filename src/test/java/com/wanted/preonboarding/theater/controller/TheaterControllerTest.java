package com.wanted.preonboarding.theater.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanted.preonboarding.theater.service.TheaterService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(TheaterController.class)
class TheaterControllerTest {

    private final static String WELCOME_API = "/theater/hello";
    private final static String ENTER_API = "/theater/enter";

    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    TheaterService theaterService;

    @Test
    @DisplayName("환영 메시지를 출력한다. ")
    void welcome() throws Exception {
        // given

        // when
        ResultActions actions = mvc.perform(get(WELCOME_API));

        // then
        String responseBody = actions.andReturn().getResponse().getContentAsString();
        assertThat(responseBody).isEqualTo("Welcome to The Wanted Theater");
    }

    @Test
    @DisplayName("영화관에 입장시킨다. ")
    void enter() throws Exception {
        // given
        long amount = 3000L;
        boolean doesHaveInvitation = true;
        given(theaterService.enter(amount, doesHaveInvitation)).willReturn(TheaterService.ENTER_MESSAGE);

        // when
        ResultActions actions = mvc.perform(get(ENTER_API)
                .param("amount", String.valueOf(amount))
                .param("doesHaveInvitation", String.valueOf(doesHaveInvitation))
        );

        // then
        String responseBody = actions.andReturn().getResponse().getContentAsString();
        assertThat(responseBody).isEqualTo(TheaterService.ENTER_MESSAGE);
    }
}