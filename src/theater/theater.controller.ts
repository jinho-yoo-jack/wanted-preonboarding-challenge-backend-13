import { Controller, Get } from '@nestjs/common';
import { TheaterService } from './theater.service';

@Controller('theater')
export class TheaterController {
  constructor(private readonly theaterService: TheaterService) {}

  @Get('/hello')
  welcomeMessage() {
    return 'Welcome to The Wanted Theater';
  }

  @Get('/enter')
  enter() {
    return this.theaterService.enter();
  }
}
