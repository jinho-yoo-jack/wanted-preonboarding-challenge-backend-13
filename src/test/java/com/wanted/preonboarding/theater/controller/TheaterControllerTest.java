package com.wanted.preonboarding.theater.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.wanted.preonboarding.theater.dto.request.EnterTheaterRequest;
import com.wanted.preonboarding.theater.fixture.EnterTheaterFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class TheaterControllerTest {

    @Autowired
    private MockMvc mvc;

    private static final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @Test
    @DisplayName("입장 성공 - 입장권 있을 때")

    void successEnterTheaterWhenConsumerHasInvitation() throws Exception {

        // given
        EnterTheaterRequest successEnterRequest = EnterTheaterFixture.SUCCESS_ENTER_REQUEST_INVITATION;

        String json = objectMapper.writeValueAsString(successEnterRequest);

        // expected
        mvc.perform(get("/theater/enter")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.content().string("Have a good time."));
    }

    @Test
    @DisplayName("입장 성공 - 입장권 없을 때 티켓 구매")
    void successEnterTheaterWhenBuyTicket() throws Exception {

        // given
        EnterTheaterRequest successEnterRequest = EnterTheaterFixture.SUCCESS_ENTER_REQUEST_BUT_TICKET;

        String json = objectMapper.writeValueAsString(successEnterRequest);

        // expected
        mvc.perform(get("/theater/enter")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.content().string("Have a good time."));
    }

    @Test
    @DisplayName("입장 실패 - 입장권 없을 때 티켓 구매할 amount 부족")
    void failEnterTheaterWhenNotEnoughAmount() throws Exception {

        // given
        EnterTheaterRequest successEnterRequest = EnterTheaterFixture.FAIL_ENTER_REQUEST_BUT_TICKET;

        String json = objectMapper.writeValueAsString(successEnterRequest);

        // expected
        mvc.perform(get("/theater/enter")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.content().string("not enough amount to buy ticket."));


    }


}