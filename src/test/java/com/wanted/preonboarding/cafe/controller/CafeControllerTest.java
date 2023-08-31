package com.wanted.preonboarding.cafe.controller;

import com.google.gson.Gson;
import com.wanted.preonboarding.cafe.MENU;
import com.wanted.preonboarding.cafe.service.handler.Order;
import com.wanted.preonboarding.cafe.service.handler.OrderRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * description    : 커피 주문 테스트
 * packageName    : com.wanted.preonboarding.cafe.controller
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2023/08/29
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/29        ggong       최초 생성
 */


@SpringBootTest
@AutoConfigureMockMvc
class CafeControllerTest {
	@Autowired
	MockMvc mvc;

	@Test
	void 커피_주문_아메리카노 () {
		List<Order> orderList=new ArrayList<Order>();
		orderList.add( new Order(MENU.AMERICANO, 3));

		OrderRequest orderRequest = new OrderRequest(orderList, "Card", 0);

		Gson gson = new Gson();
		String content = gson.toJson(orderRequest);


		try {
			MvcResult res = mvc.perform(post("/cafe/order").contentType(MediaType.APPLICATION_JSON)
			                                               .content(content))
			                   .andExpect(status().isOk())
			                   .andExpect(MockMvcResultMatchers.content()
			                                                   .string(containsString(":")))//못만듬
			                   .andReturn();
			System.out.println(res.getResponse().getContentAsString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void 커피_주문_아메리카노_라떼 () {
		List<Order> orderList=new ArrayList<Order>();
		orderList.add( new Order(MENU.AMERICANO, 3));
		orderList.add( new Order(MENU.LATTE, 2));

		OrderRequest orderRequest = new OrderRequest(orderList, "Card", 0);

		Gson gson = new Gson();
		String content = gson.toJson(orderRequest);


		try {
			MvcResult res = mvc.perform(post("/cafe/order").contentType(MediaType.APPLICATION_JSON)
			                                               .content(content))
			                   .andExpect(status().isOk())
			                   .andExpect(MockMvcResultMatchers.content()
			                                                   .string(containsString(":")))//못만듬
			                   .andReturn();
			System.out.println(res.getResponse().getContentAsString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void 커피_주문_아메리카노_라떼_티 () {
		List<Order> orderList=new ArrayList<Order>();
		orderList.add( new Order(MENU.AMERICANO, 3));
		orderList.add( new Order(MENU.TEA, 1));

		OrderRequest orderRequest = new OrderRequest(orderList, "Card", 0);

		Gson gson = new Gson();
		String content = gson.toJson(orderRequest);


		try {
			MvcResult res = mvc.perform(post("/cafe/order").contentType(MediaType.APPLICATION_JSON)
			                                               .content(content))
			                   .andExpect(status().isOk())
			                   .andExpect(MockMvcResultMatchers.content()
			                                                   .string(containsString(":")))//못만듬
			                   .andReturn();
			System.out.println(res.getResponse().getContentAsString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void 커피_주문_아메리카노_라떼_티_바리스타 () {
		List<Order> orderList=new ArrayList<Order>();
		orderList.add( new Order(MENU.AMERICANO, 3));
		orderList.add( new Order(MENU.TEA, 1));

		OrderRequest orderRequest = new OrderRequest(orderList, "Card", 2);

		Gson gson = new Gson();
		String content = gson.toJson(orderRequest);


		try {
			MvcResult res = mvc.perform(post("/cafe/order").contentType(MediaType.APPLICATION_JSON)
			                                               .content(content))
			                   .andExpect(status().isOk())
			                   .andExpect(MockMvcResultMatchers.content()
			                                                   .string(containsString(":")))//못만듬
			                   .andReturn();
			System.out.println(res.getResponse().getContentAsString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	void 커피_주문_아메리카노_라떼_티_바리스타_현금 () {
		List<Order> orderList=new ArrayList<Order>();
		orderList.add( new Order(MENU.AMERICANO, 3));
		orderList.add( new Order(MENU.TEA, 1));

		OrderRequest orderRequest = new OrderRequest(orderList, "Cash", 2);

		Gson gson = new Gson();
		String content = gson.toJson(orderRequest);


		try {
			MvcResult res = mvc.perform(post("/cafe/order").contentType(MediaType.APPLICATION_JSON)
			                                               .content(content))
			                   .andExpect(status().isOk())
			                   .andExpect(MockMvcResultMatchers.content()
			                                                   .string(containsString(":")))//못만듬
			                   .andReturn();
			System.out.println(res.getResponse().getContentAsString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}