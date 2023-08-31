package com.wanted.preonboarding.cafe.medium;

import com.wanted.preonboarding.cafe.dto.OrderRequest;
import com.wanted.preonboarding.cafe.service.CafeService;
import com.wanted.preonboarding.cafe.service.handler.Menu;
import com.wanted.preonboarding.cafe.service.handler.PaymentMethod;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CafeServiceTest {

    @Autowired
    CafeService cafeService;

    @Test
    public void OrderRequest로_주문할_수_있다() {
        // given
        List<OrderRequest.MenuDto> menus = new ArrayList<>();

        OrderRequest.MenuDto menuDto1 = new OrderRequest.MenuDto();
        menuDto1.setMenu(Menu.AMERICANO);
        menuDto1.setCount(1);
        menus.add(menuDto1);

        OrderRequest.MenuDto menuDto2 = new OrderRequest.MenuDto();
        menuDto2.setMenu(Menu.ICE_CHOCO);
        menuDto2.setCount(1);
        menus.add(menuDto2);

        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setMenus(menus);
        orderRequest.setPaymentMethod(PaymentMethod.CARD);

        // when
        String orderMessage = cafeService.orderFrom(orderRequest);

        // then
        Assertions.assertThat(orderMessage).isEqualTo("AMERICANO:1 ICE_CHOCO:1 ");
    }

}
