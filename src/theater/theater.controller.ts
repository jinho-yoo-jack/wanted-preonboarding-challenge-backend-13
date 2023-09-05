import { Body, Controller, Get, Post } from '@nestjs/common';
import { TheaterService } from './theater.service';
import { UserDto } from './dto/user.dto';

@Controller('theater')
export class TheaterController {
  constructor(private readonly theaterService: TheaterService) {}

  @Get('/hello')
  welcomeMessage() {
    return 'Welcome to The Wanted Theater';
  }

  //todo 완료 1. 관람객의 정보를 request body로 받는다 그리고 그 body는 dto로 변환하여 service에 전달한다.
  //todo 완료 7. dto에 입장권이 없다면 티켓 구매할 돈이 있는지를 검증할 책임을 둔다.
  // 한 번에 한 명씩 입장할 수 있다고 가정. 한 번에 여러명이 입장할 수 있는 경우는 배제한다.

  @Post('/enter')
  enter(@Body() dto: UserDto) {
    try {
      return this.theaterService.enter(dto.toEntity());
    } catch (error) {
      return { message: error.message };
    }
  }
}
