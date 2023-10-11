package com.wanted.preonboarding.theater.controller;

import com.wanted.preonboarding.exception.BadRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TheaterControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void welcomeMessage() throws Exception {
        this.mvc.perform(get("/theater/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Welcome to The Wanted Theater"));
    }

    @Test
    public void 입장_성공_티켓소지() throws Exception {
        this.mvc.perform(get("/theater/enter")
                        .param("when", "2020.02.02 12:00:00")
                        .param("amount", ""))
                .andExpect(status().isOk())
                .andExpect(content().string("Have a good time."));
    }

    @Test
    public void 입장_성공_티켓미소지() throws Exception {
        this.mvc.perform(get("/theater/enter")
                        .param("when", "")
                        .param("amount", "10000"))
                .andExpect(status().isOk())
                .andExpect(content().string("Have a good time."));
    }

    @Test
    public void 입장_실패() throws Exception {
        this.mvc.perform(get("/theater/enter"))
                .andExpect(status().isBadRequest())
                .andExpect(
                        result -> assertTrue(result.getResolvedException() instanceof BadRequest
                        )
                )
                .andExpect(result -> assertEquals("금액이 부족합니다.", result.getResolvedException().getMessage()));
    }

}