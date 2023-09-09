import { Injectable } from '@nestjs/common';
import { Cashier } from './entity/cashier.entity';
import { Customer } from './entity/customer.entity';

@Injectable()
export class CafeService {
  constructor(private readonly cashier: Cashier) {}

  orderFrom(customer: Customer) {
    const { orders, paymentMethod } = customer.buyMenu();
    return this.cashier.takeOrder(orders, paymentMethod);
  }
}
