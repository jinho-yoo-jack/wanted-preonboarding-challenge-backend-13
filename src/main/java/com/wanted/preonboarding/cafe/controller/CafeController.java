package com.wanted.preonboarding.cafe.controller;

import com.wanted.preonboarding.cafe.service.CafeService;
import com.wanted.preonboarding.cafe.service.handler.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/cafe")
@RequiredArgsConstructor
public class CafeController {
    private final CafeService cafeService;


    @PostMapping("order2")
    public String order(@RequestBody OrderRequest request) {
        try {
            return cafeService.order(request);
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }
}
