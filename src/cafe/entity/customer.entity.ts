import { Cashier } from './cashier.entity';
export class Customer {
  private readonly myOrders: Map<string, number>;

  constructor(
    private _paymentMethod: string,
    orders: Map<string, number>,
  ) {
    this.myOrders = orders;
  }

  private set paymentMethod(paymentMethod: string) {
    this._paymentMethod = paymentMethod;
  }

  buyCoffee(cashier: Cashier) {
    const totalPrice: bigint = cashier.calculateTotalPrice(this.myOrders);
    return cashier.takeOrder(this.myOrders, totalPrice);
  }
}
