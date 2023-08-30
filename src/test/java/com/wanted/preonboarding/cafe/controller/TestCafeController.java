package com.wanted.preonboarding.cafe.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanted.preonboarding.cafe.dto.OrderMenuItemDTO;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CafeController.class)
public class TestCafeController {
    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("order test")
    public void testOrder() throws Exception {
        // GIVEN
        OrderMenuItemDTO itemDTO = OrderMenuItemDTO.builder()
                .build();
        // WHEN
        mvc.perform(MockMvcRequestBuilders
                .get("/cafe/order")
                        .content(asJsonString(itemDTO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()); // THEN
    }

    @Test
    @DisplayName("dto test")
    public void testDTOInput() throws Exception {
        /* !! 'CafeService' NoSuchBeanDefinitionException 발생 !! */
        // GIVEN
        JSONObject inputJson = new JSONObject();
        inputJson.put("beveragetype", "americano");
        // WHEN
        mvc.perform(MockMvcRequestBuilders
                .get("/cafe/order")
                        .content(asJsonString(inputJson))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()); // THEN
    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
