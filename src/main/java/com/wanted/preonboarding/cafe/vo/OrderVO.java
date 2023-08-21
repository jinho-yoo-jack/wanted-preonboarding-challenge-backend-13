package com.wanted.preonboarding.cafe.vo;

import com.wanted.preonboarding.cafe.service.handler.Customer;
import com.wanted.preonboarding.cafe.service.handler.Order;
import com.wanted.preonboarding.cafe.service.handler.OrderMenu;
import com.wanted.preonboarding.cafe.service.handler.Payment;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class OrderVO {

    private Payment payment;
    private List<OrderMenuVO> orderMenuList;

    @Getter
    @Setter
    @ToString
    public static class OrderMenuVO {
        private String name;
        private Long quantity;

        public void addQuantity(Long quantity) {
            Long quantityValue = this.quantity == null ? 0L : this.quantity;
            Long addQuantityValue = quantity == null ? 0L : quantity;
            this.quantity = quantityValue + addQuantityValue;
        }

        @Override
        public boolean equals(Object obj) {
            if ( obj == null ) return false;
            boolean isOrderMenuVO = obj instanceof OrderMenuVO;
            if ( !isOrderMenuVO ) return false;
            OrderMenuVO target = (OrderMenuVO) obj;
            return this.name.equals(target.name);
        }

        public OrderMenu toOrderMenu() {
            return new OrderMenu(this.name, this.quantity);
        }
    }

    public Customer toCustomerOrder() {
        if ( this.orderMenuList == null ) {
            throw new RuntimeException("주문할 메뉴가 존재하지 않습니다.");
        }

        List<OrderMenuVO> noDuplicatedOrderMenuVo = new ArrayList<>();
        for (OrderMenuVO x : this.orderMenuList) {
            noDuplicatedOrderMenuVo.stream()
                    .filter(orderMenu -> orderMenu.equals(x))
                    .findFirst()
                    .ifPresentOrElse(
                            orderMenuVO -> orderMenuVO.addQuantity(x.getQuantity()),
                            () -> noDuplicatedOrderMenuVo.add(x)
                    );
        }

        if ( noDuplicatedOrderMenuVo.size() > 3 ) {
            throw new RuntimeException("한번에 최대 3개의 메뉴에 대해서만 주문이 가능합니다.");
        }

        Set<OrderMenu> orderMenuSet = new HashSet<>(noDuplicatedOrderMenuVo.stream().map(OrderMenuVO::toOrderMenu).toList());
        Order order = new Order(this.payment, orderMenuSet);
        return new Customer(order);
    }
}
