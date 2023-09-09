export enum PaymentMethod {
  CARD = 'CARD',
  CASH = 'CASH',
}

interface CustomerProps {
  paymentMethod: PaymentMethod;
  orders: Map<string, number>;
}

export class Customer {
  private readonly myOrders: Map<string, number>;
  private paymentMethod: PaymentMethod;

  constructor({ paymentMethod, orders }: CustomerProps) {
    this.myOrders = orders;
    this.paymentMethod = paymentMethod;
  }

  static of({ paymentMethod, orders }: CustomerProps) {
    return new Customer({ paymentMethod, orders });
  }

  buyMenu() {
    // 현금과 카드를 가진 wallet을 만들어서 customer가 갖고 있게 해야겠다.
    return { orders: this.myOrders, paymentMethod: this.paymentMethod };
  }
}
