import { Controller, Get } from '@nestjs/common';
import { CafeService } from './cafe.service';

@Controller('cafe')
export class CafeController {
  constructor(private readonly cafeService: CafeService) {}

  @Get('/hello')
  welcomeMessage() {
    return 'Welcome to The Wanted coding cafe!!';
  }

  @Get('/order')
  orderFromMenu() {
    const menu = new Map<string, number>();

    menu.set('AMERICANO', 3);

    return this.cafeService.orderFrom(menu);
  }
}
