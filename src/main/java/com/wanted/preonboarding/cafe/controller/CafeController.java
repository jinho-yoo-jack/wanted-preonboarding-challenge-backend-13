package com.wanted.preonboarding.cafe.controller;

import com.wanted.preonboarding.cafe.service.CafeService;
import com.wanted.preonboarding.cafe.service.handler.OrderRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cafe")
@RequiredArgsConstructor
@Slf4j
public class CafeController {
    private final CafeService cafeService;

    @GetMapping("/hello")
    public String welcomeMessage(){
        return "Welcome to The Wanted coding cafe!!";
    }

    @PostMapping("/order")
    public String orderFromMenu(@Valid @RequestBody OrderRequest orderRequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            log.error("주문 양식 작성 오류");
            return "주문 양식 작성이 잘못되었습니다.";
        }

        // 주문이 가능한지 확인하고
        if (!cafeService.checkMakeCoffee(orderRequest)) {
            log.error("주문 불가능 상태");
            return "지금은 만들수 없습니다.";
        }
        // 가능하면 결제하고
        cafeService.payOrderRequest(orderRequest);

        // 결제가 완료되면, 메뉴 제작 시작
        cafeService.makeCoffee(orderRequest);
        return cafeService.makeCoffee(orderRequest);
    }
}
