package com.wanted.preonboarding.cafe.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanted.preonboarding.cafe.domain.MenuRequestDto;
import com.wanted.preonboarding.exception.BadRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CafeControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void welcomeMessage() throws Exception {
        this.mvc.perform(get("/cafe/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Welcome to The Wanted coding cafe!!"));
    }

    @Test
    public void 주문_성공() throws Exception {

        List<MenuRequestDto> list = new ArrayList<>();
        MenuRequestDto americano = MenuRequestDto.builder()
                .menuName("AMERICANO")
                .quantity(3)
                .build();
        MenuRequestDto iceTea = MenuRequestDto.builder()
                .menuName("ICE_TEA")
                .quantity(3)
                .build();
        MenuRequestDto latte = MenuRequestDto.builder()
                .menuName("LATTE")
                .quantity(1)
                .build();
        list.add(americano);
        list.add(iceTea);
        list.add(latte);

        String jsonArray = mapper.writeValueAsString(list);

        this.mvc.perform(post("/cafe/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonArray))
                .andExpect(status().isOk())
                .andExpect(content().string("AMERICANO:3 ICE_TEA:3 LATTE:1 "));
    }

    @Test
    public void 주문_실패_없는메뉴() throws Exception {
        List<MenuRequestDto> list = new ArrayList<>();
        MenuRequestDto choco = MenuRequestDto.builder()
                .menuName("CHOCO")
                .quantity(3)
                .build();
        list.add(choco);

        String jsonArray = mapper.writeValueAsString(list);

        this.mvc.perform(post("/cafe/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonArray))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof BadRequest))
                .andExpect(result -> assertEquals("메뉴가 존재하지 않습니다.", result.getResolvedException().getMessage()));
    }
}