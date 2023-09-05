package com.wanted.preonboarding.theater.controller;

import com.wanted.preonboarding.IntegrationTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class TheaterControllerTest extends IntegrationTest {

    @Test
    void enter() throws Exception {
        mvc.perform(
                get("/theater/enter")
                )
                .andDo(print())
                .andExpect(status().isOk());
    }
}