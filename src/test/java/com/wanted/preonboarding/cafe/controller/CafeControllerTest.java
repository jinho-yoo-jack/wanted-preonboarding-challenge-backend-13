package com.wanted.preonboarding.cafe.controller;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanted.preonboarding.cafe.domain.Menu;
import com.wanted.preonboarding.cafe.domain.Order;
import com.wanted.preonboarding.cafe.domain.PaymentType;
import com.wanted.preonboarding.cafe.dto.OrderRequest;
import java.util.List;

import com.wanted.preonboarding.cafe.service.CafeService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@WebMvcTest(controllers = CafeController.class)
class CafeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @SpyBean
    private ObjectMapper objectMapper;

    @MockBean
    private CafeService cafeService;

    private final String endPoint = "/cafe";

    @Test
    @DisplayName("환영 인사 성공")
    void greetingSuccess() throws Exception {
        //when & then
        mockMvc.perform(get(endPoint + "/hello")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Nested
    @DisplayName("주문")
    class order {
        @Test
        @DisplayName("주문 성공")
        void orderSuccess() throws Exception {
            //given
            final OrderRequest orderRequest = new OrderRequest(PaymentType.CARD, List.of(new Order(Menu.AMERICANO, 3)));

            final String requestBody = objectMapper.writeValueAsString(orderRequest);

            final String expectedResponse = "AMERICANO:3";
            given(cafeService.orderFrom(eq(orderRequest))).willReturn(expectedResponse);

            //when
            MvcResult mvcResult = mockMvc.perform(get(endPoint + "/order")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(requestBody))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andReturn();

            String response = mvcResult.getResponse().getContentAsString();

            assertThat(response).isEqualTo(expectedResponse);
        }

        @Test
        @DisplayName("바리스타가 바빠 주문 실패")
        void orderFailed() throws Exception {
            //given
            final OrderRequest orderRequest = new OrderRequest(PaymentType.CARD, List.of(new Order(Menu.AMERICANO, 3)));

            final String requestBody = objectMapper.writeValueAsString(orderRequest);

            given(cafeService.orderFrom(any(OrderRequest.class))).willThrow(IllegalStateException.class);

            //when & then
            mockMvc.perform(get(endPoint + "/order")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(requestBody))
                    .andExpect(MockMvcResultMatchers.status().isServiceUnavailable());
        }
    }

    @Test
    @DisplayName("잘못된 주문 요청 값이 들어왔을 때 실패")
    void invalidRequest() throws Exception {
        //given
        final OrderRequest orderRequest = new OrderRequest(null, null);

        final String requestBody = objectMapper.writeValueAsString(orderRequest);

        //then & when
        mockMvc.perform(get(endPoint + "/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}