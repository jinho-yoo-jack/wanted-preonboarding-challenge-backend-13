package com.wanted.preonboarding.cafe.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanted.preonboarding.cafe.service.CafeService;
import com.wanted.preonboarding.theater.service.TheaterService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(CafeController.class)
class CafeControllerTest {
    private final static String WELCOME_API = "/cafe/hello";
    private final static String ORDER_API = "/cafe/order";

    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    CafeService cafeService;

    @Test
    @DisplayName("환영 메시지를 출력한다. ")
    void welcome() throws Exception {
        // given

        // when
        ResultActions actions = mvc.perform(get(WELCOME_API));

        // then
        String responseBody = actions.andReturn().getResponse().getContentAsString();
        assertThat(responseBody).isEqualTo(CafeController.WELCOME_MESSAGE);
    }

    @Test
    @DisplayName("메뉴를 주문한다.  ")
    void order() throws Exception {
        // given
        HashMap<String, Integer> map = new HashMap<>();
        map.put("AMERICANO", 3);
        given(cafeService.orderFrom(map)).willReturn("AMERICANO:3");

        // when
        ResultActions actions = mvc.perform(get(ORDER_API));

        // then
        String responseBody = actions.andReturn().getResponse().getContentAsString();
        assertThat(responseBody).isEqualTo("AMERICANO:3");
    }
}