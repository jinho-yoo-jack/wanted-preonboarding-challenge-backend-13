import { Body, Controller, Get, Post } from '@nestjs/common';
import { CafeService } from './cafe.service';
import { CustomerDto } from './dto/customer.dto';

@Controller('cafe')
export class CafeController {
  constructor(private readonly cafeService: CafeService) {}

  @Get('/hello')
  welcomeMessage() {
    return 'Welcome to The Wanted coding cafe!!';
  }

  /**
   * @todo 과제
   * 현재 주문 가능한 음료는 오직 아메리카노뿐인데, 주문 가능한 음료의 수를 최대 3개까지 확장해보자.
   * 각각의 객체들이 적절한 책임과 책임의 범위를 가지고 있는지 확인해보고, 너무 많은 책임과 넓은 범위의 책임을 가지고 있다면 적절하게 수정해보자.
   * CafeService의 order() 비즈니스 로직이 정상 실행되는지 확인해보자.
   * 주문할 음료와 수량은 RequestBody로 받아서 처리하자. -> dto 만들기
   */
  @Post('/order')
  orderFromMenu(@Body() dto: CustomerDto) {
    try {
      return this.cafeService.orderFrom(dto.toEntity());
    } catch (error) {
      return { message: error.message };
    }
  }
}
