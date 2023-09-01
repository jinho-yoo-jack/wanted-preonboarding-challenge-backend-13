package com.wanted.preonboarding.cafe.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanted.preonboarding.cafe.domain.Menu;
import com.wanted.preonboarding.cafe.domain.Order;
import com.wanted.preonboarding.cafe.domain.PaymentType;
import com.wanted.preonboarding.cafe.dto.OrderRequest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class CafeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private final String endPoint = "/cafe";

    @Test
    @DisplayName("성공")
    void success() throws Exception {
        //given
        final OrderRequest orderRequest = new OrderRequest(PaymentType.CARD, List.of(new Order(Menu.AMERICANO, 3)));

        final String requestBody = objectMapper.writeValueAsString(orderRequest);

        //when & then
        mockMvc.perform(get(endPoint + "/order")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }
}