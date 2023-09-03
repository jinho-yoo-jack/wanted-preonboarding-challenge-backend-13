package com.wanted.preonboarding.theater.controller;

import com.wanted.preonboarding.cafe.service.CafeService;
import com.wanted.preonboarding.theater.service.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/theater")
@RequiredArgsConstructor
public class TheaterController {
    private final TheaterService theaterService;

    /**
     * 극장 메인 API
     * @return 환영 메시지
     */
    @GetMapping("hello")
    public String welcomeMessage(){
        return "Welcome to The Wanted Theater";
    }

    /**
     * 극장 입장 API
     * @return 입장 메시지
     */
    @GetMapping("enterTheater")
    public String enterTheater(@RequestParam int audienceId) {
        if (audienceId <= 0) {
            return "잘못된 사용자입니다. 극장 입장을 할 수 없습니다.";
        }

        var audience = theaterService.getAudience(audienceId);
        if (audience == null) {
            return "문제가 발생하였습니다. 관리자에게 문의하세요.";
        }
        var enterTheaterResult = theaterService.enterTheater(audience);
        
        if (enterTheaterResult) return "Welcom to the wanted theater";
        else return "fail to the wanted theater";
    }
}
