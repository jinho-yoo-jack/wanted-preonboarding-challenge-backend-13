package com.wanted.preonboarding.theater.controller;

import com.google.gson.Gson;
import com.wanted.preonboarding.theater.service.handler.AudienceInfoRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * description    : 극장 관련 테스트
 * packageName    : com.wanted.preonboarding.theater.controller
 * fileName       : IntelliJ IDEA
 * author         : ggong
 * date           : 2023/08/26
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/26        ggong       최초 생성
 */
@SpringBootTest
@AutoConfigureMockMvc
class TheaterControllerTest {

	@Autowired
	MockMvc mvc;

	@Test
	void 티켓만_있는경우() {
		AudienceInfoRequest audienceInfoRequest = new AudienceInfoRequest();
		audienceInfoRequest.setAmount(0L);
		audienceInfoRequest.setTicket(true);
		audienceInfoRequest.setLocationDateTime(null);

		Gson gson = new Gson();
		String content = gson.toJson(audienceInfoRequest);

		try {
			MvcResult res = mvc.perform(post("/theater/enter").contentType(MediaType.APPLICATION_JSON)
			                                                   .content(content))
			                    .andExpect(status().isOk())
			                    .andExpect(MockMvcResultMatchers.content()
			                                                    .string(containsString("허용")))
			                    .andReturn();
			System.out.println(res.getResponse().getContentAsString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void 초대권만_있는경우() {
		AudienceInfoRequest audienceInfoRequest = new AudienceInfoRequest();
		audienceInfoRequest.setAmount(0L);
		audienceInfoRequest.setTicket(false);
		LocalDateTime yesterday = LocalDateTime.parse(LocalDateTime.now()
		                                                           .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH")));
		audienceInfoRequest.setLocationDateTime(yesterday.toString());

		Gson gson = new Gson();
		String content = gson.toJson(audienceInfoRequest);

		try {
			MvcResult res = mvc.perform(post("/theater/enter").contentType(MediaType.APPLICATION_JSON)
			                                                   .content(content))
			                    .andExpect(status().isOk())
			                    .andExpect(MockMvcResultMatchers.content()
			                                                    .string(containsString("허용")))
			                    .andReturn();
			System.out.println(res.getResponse().getContentAsString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void 돈만_있는경우() {
		AudienceInfoRequest audienceInfoRequest = new AudienceInfoRequest();
		audienceInfoRequest.setAmount(10000);
		audienceInfoRequest.setTicket(false);
		audienceInfoRequest.setLocationDateTime(null);

		Gson gson = new Gson();
		String content = gson.toJson(audienceInfoRequest);

		try {
			MvcResult res = mvc.perform(post("/theater/enter").contentType(MediaType.APPLICATION_JSON)
			                                                   .content(content))
			                    .andExpect(status().isOk())
			                    .andExpect(MockMvcResultMatchers.content()
			                                                    .string(containsString("허용")))
			                    .andReturn();
			System.out.println(res.getResponse().getContentAsString());


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void 초대권이_있지만_날짜가_지남_돈은_있는_경우() {
		AudienceInfoRequest audienceInfoRequest = new AudienceInfoRequest();
		audienceInfoRequest.setAmount(10000);
		audienceInfoRequest.setTicket(false);
		LocalDateTime yesterday = LocalDateTime.parse(LocalDateTime.now()
		                                                           .minusDays(1)
		                                                           .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH")));
		audienceInfoRequest.setLocationDateTime(yesterday.toString());

		Gson gson = new Gson();
		String content = gson.toJson(audienceInfoRequest);

		try {
			MvcResult res = mvc.perform(post("/theater/enter").contentType(MediaType.APPLICATION_JSON)
			                                                   .content(content))
			                    .andExpect(status().isOk())
			                    .andExpect(MockMvcResultMatchers.content()
			                                                    .string(containsString("허용")))
			                    .andReturn();
			System.out.println(res.getResponse().getContentAsString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void 초대권이_있지만_날짜가_지남_돈이없음_경우() {
		AudienceInfoRequest audienceInfoRequest = new AudienceInfoRequest();
		audienceInfoRequest.setAmount(0);
		audienceInfoRequest.setTicket(false);
		LocalDateTime yesterday = LocalDateTime.parse(LocalDateTime.now()
		                                                           .minusDays(1)
		                                                           .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH")));
		audienceInfoRequest.setLocationDateTime(yesterday.toString());

		Gson gson = new Gson();
		String content = gson.toJson(audienceInfoRequest);

		try {
			MvcResult res = mvc.perform(post("/theater/enter").contentType(MediaType.APPLICATION_JSON)
			                                                    .content(content))
			                     .andExpect(status().isOk())
			                     .andExpect(MockMvcResultMatchers.content()
			                                                     .string(containsString("불가")))
			                     .andReturn();
			System.out.println(res.getResponse().getContentAsString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void 돈이부족() {
		AudienceInfoRequest audienceInfoRequest = new AudienceInfoRequest();
		audienceInfoRequest.setAmount(0);
		audienceInfoRequest.setTicket(false);
		audienceInfoRequest.setLocationDateTime(null);

		Gson gson = new Gson();
		String content = gson.toJson(audienceInfoRequest);

		try {
			MvcResult res = mvc.perform(post("/theater/enter").contentType(MediaType.APPLICATION_JSON)
			                                                  .content(content))
			                   .andExpect(status().isOk())
			                   .andExpect(MockMvcResultMatchers.content()
			                                                   .string(containsString("불가")))
			                   .andReturn();
			System.out.println(res.getResponse()
			                      .getContentAsString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void 돈이딱맞게() {
		AudienceInfoRequest audienceInfoRequest = new AudienceInfoRequest();
		audienceInfoRequest.setAmount(100);
		audienceInfoRequest.setTicket(false);
		audienceInfoRequest.setLocationDateTime(null);

		Gson gson = new Gson();
		String content = gson.toJson(audienceInfoRequest);

		try {
			MvcResult res = mvc.perform(post("/theater/enter").contentType(MediaType.APPLICATION_JSON)
			                                                  .content(content))
			                   .andExpect(status().isOk())
			                   .andExpect(MockMvcResultMatchers.content()
			                                                   .string(containsString("허용")))
			                   .andReturn();
			System.out.println(res.getResponse()
			                      .getContentAsString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}