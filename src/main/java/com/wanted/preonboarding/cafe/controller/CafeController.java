package com.wanted.preonboarding.cafe.controller;

import com.wanted.preonboarding.cafe.controller.request.CafeOrderRequest;
import com.wanted.preonboarding.cafe.controller.response.CafeOrderResponse;
import com.wanted.preonboarding.cafe.service.CafeService;
import com.wanted.preonboarding.cafe.service.handler.domain.Drink;
import com.wanted.preonboarding.cafe.service.handler.dto.CafeOrderResultDto;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/cafe")
@RequiredArgsConstructor
public class CafeController {
    private final CafeService cafeService;

    @GetMapping("hello")
    public String welcomeMessage(){
        return "Welcome to The Wanted coding cafe!!";
    }

    @PostMapping("order")
    public ResponseEntity<CafeOrderResponse> orderFromMenu(@RequestBody CafeOrderRequest orderRequest){
        Map<Drink, Integer> itemMap = orderRequest.toOrderItemMap();
        CafeOrderResultDto resultDto = cafeService.orderFrom(itemMap);
        return ResponseEntity.ok(CafeOrderResponse.of(resultDto));
    }
}
