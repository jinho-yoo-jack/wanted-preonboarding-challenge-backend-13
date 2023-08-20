import { Injectable } from '@nestjs/common';
import { Cafe } from './entity/cafe.entity';
import { Cashier } from './entity/cashier.entity';
import { Customer } from './entity/customer.entity';

@Injectable()
export class CafeService {
  constructor(private readonly wantedCafe: Cafe) {}

  orderFrom(menu: Map<string, number>) {
    const cashier = new Cashier(this.wantedCafe);
    const myOrders = new Map<string, number>();
    myOrders.set('AMERICANO', 3);
    const c1 = new Customer('Card', myOrders);

    return c1.buyCoffee(cashier);
  }
}
