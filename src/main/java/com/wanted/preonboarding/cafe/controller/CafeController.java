package com.wanted.preonboarding.cafe.controller;

import com.wanted.preonboarding.cafe.controller.reponse.CafeOrderResponse;
import com.wanted.preonboarding.cafe.controller.request.CafeOrderRequest;
import com.wanted.preonboarding.cafe.service.CafeService;
import com.wanted.preonboarding.cafe.service.handler.domain.Menu;
import com.wanted.preonboarding.cafe.service.handler.dto.CafeOrderResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
        Map<Menu, Integer> itemMap = orderRequest.toOrderItemMap();
        CafeOrderResultDto resultDto = cafeService.orderFrom(itemMap);
        return ResponseEntity.ok(CafeOrderResponse.of(resultDto));
    }
}
