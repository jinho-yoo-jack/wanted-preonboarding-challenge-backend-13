package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.exception.LackOfBalanceException;

import java.util.Map;

public class Customer {
    // Enum 보다는 인터페이스로 두는 것이 나을 것 같지만, PaymentMethod 로 어떤 행동을 해야하는지 알 수 없어 이대로 두었습니다
    private PaymentMethod paymentMethod;
    private final Order myOrder;
    private long amount;

    public Customer(PaymentMethod paymentMethod, Map<String, Integer> orders, long amount) {
        this.paymentMethod = paymentMethod;
        this.myOrder = Order.create(Menu.createMenuItemMap(orders), new DefaultMenuCalculable());
        this.amount = amount;
    }

    private void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    private void minusAmount(long fee) {
        if (amount - fee < 0) throw LackOfBalanceException.builder().requiredAmount(fee).currentBalance(amount).build();
        this.amount -= fee;
    }

    public String buyCoffee(Cashier cashier) {
        long totalPrice = cashier.calculateTotalPrice(myOrder);
        minusAmount(totalPrice);
        return cashier.takeOrder(myOrder, totalPrice);
    }

}
