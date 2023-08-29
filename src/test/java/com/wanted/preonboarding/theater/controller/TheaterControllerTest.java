package com.wanted.preonboarding.theater.controller;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanted.preonboarding.theater.controller.request.TheaterEnterRequest;
import com.wanted.preonboarding.theater.service.TheaterService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(TheaterController.class)
class TheaterControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    TheaterService theaterService;

    @Test
    @DisplayName("티켓을 보유한 고객은 극장으로 입장시킨다.")
    void enter_theater_for_audience_has_ticket() throws Exception {
        // given
        // 티켓이 있으면 입장시키고 없으면 구매 후 입장시킨다.
        // 티켓은 있을 수 도, 없을 수 도 있다.
        TheaterEnterRequest theaterEnterRequest = new TheaterEnterRequest(true, 10000);
        String content = objectMapper.writeValueAsString(theaterEnterRequest);

        when(theaterService.enter(any())).thenReturn(
                "Have a good time."
        );

        // when & then
        mockMvc.perform(get("/theater/enter")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is("Have a good time.")));
    }
}