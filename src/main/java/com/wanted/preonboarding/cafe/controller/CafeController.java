package com.wanted.preonboarding.cafe.controller;

import com.wanted.preonboarding.cafe.dto.OrderMenuItemDTO;
import com.wanted.preonboarding.cafe.entity.*;
import com.wanted.preonboarding.cafe.exception.MenuOrderException;
import com.wanted.preonboarding.cafe.service.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cafe")
@RequiredArgsConstructor
public class CafeController {
    private final CafeService cafeService;
    private final Order order;

    @GetMapping("hello")
    public String welcomeMessage(){
        return "Welcome to The Wanted coding cafe!!";
    }

    @GetMapping("order")
    public String orderFromMenu(@RequestBody List<OrderMenuItemDTO> orderDTOs) throws MenuOrderException {
        // 입력된 주문 DTO 리스트 -> 주문 엔티티 리스트
        List<OrderItem> orderSequence = orderDTOs.stream().map(OrderMenuItemDTO::orderMenuItemDTOToMenuItem).collect(Collectors.toList());
        // 동일한 메뉴를 다른 순서에 시킬 수 있으므로 맵으로 종합
        summarizeOrder(orderSequence);

        // 서비스에 위임
        return cafeService.orderFrom(order);
    }

    private void summarizeOrder(List<OrderItem> orderSequence) {
        for(OrderItem item : orderSequence){
            order.addComponent(item, item.getAmount());
        }
    }
}
