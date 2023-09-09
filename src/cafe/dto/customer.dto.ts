import { Expose } from 'class-transformer';
import { Menu } from '../entity/cafe.entity';
import { Customer, PaymentMethod } from '../entity/customer.entity';
import { IsNotEmpty } from 'class-validator';

export interface Order {
  menu: keyof typeof Menu;
  quantities: number;
}

export class CustomerDto {
  @Expose()
  @IsNotEmpty()
  //enum을 transfer해야 하나?
  paymentMethod: PaymentMethod;

  @Expose()
  @IsNotEmpty()
  orders: Order[];

  constructor() {}

  toEntity(): Customer {
    const orders = new Map<string, number>();

    this.orders.forEach((order) => {
      return orders.set(order.menu, order.quantities);
    });

    return Customer.of({
      paymentMethod: this.paymentMethod,
      orders: orders,
    });
  }
}
