package com.wanted.preonboarding.cafe.controller;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanted.preonboarding.cafe.controller.request.CafeOrderItemRequest;
import com.wanted.preonboarding.cafe.controller.request.CafeOrderRequest;
import com.wanted.preonboarding.cafe.service.CafeService;
import com.wanted.preonboarding.cafe.service.handler.dto.CafeOrderItemResultDto;
import com.wanted.preonboarding.cafe.service.handler.dto.CafeOrderResultDto;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CafeController.class)
class CafeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    CafeService cafeService;

    @Test
    @DisplayName("음료를 주문한다.")
    void order() throws Exception {
        // given
        List<CafeOrderItemRequest> items = Arrays.asList(
                new CafeOrderItemRequest("AMERICANO", 3),
                new CafeOrderItemRequest("LATTE", 5)
        );
        CafeOrderRequest cafeOrderRequest = new CafeOrderRequest(items);
        String content = objectMapper.writeValueAsString(cafeOrderRequest);

        when(cafeService.orderFrom(any())).thenReturn(
                new CafeOrderResultDto(
                        Arrays.asList(
                                new CafeOrderItemResultDto("AMERICANO", 3, true),
                                new CafeOrderItemResultDto("LATTE", 5, true)
                        ),
                        13000
                )
        );

        // when & then
        mockMvc.perform(post("/cafe/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("items", hasSize(2)))
                .andExpect(jsonPath("totalPrice", is(13000)));
    }
}