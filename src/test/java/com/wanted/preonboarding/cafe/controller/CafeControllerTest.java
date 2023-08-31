package com.wanted.preonboarding.cafe.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanted.preonboarding.cafe.OrderCafeFixture;
import com.wanted.preonboarding.cafe.dto.request.OrderCustomerRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class CafeControllerTest {

    @Autowired
    private MockMvc mvc;

    private final ObjectMapper objectMapper = new ObjectMapper();


    @Test
    @DisplayName("커피 주문하기 성공")
    void successOrderCoffee() throws Exception {

        // given
        OrderCustomerRequest request = OrderCafeFixture.SUCCESS_ORDER_REQUEST;

        String expectedMessage = "AMERICANO:3\nESPRESSO:2\nLATTE:1\n";
        String jsonContent = objectMapper.writeValueAsString(request);

        // expected
        mvc.perform(get("/cafe/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.content().string(expectedMessage));

    }

}