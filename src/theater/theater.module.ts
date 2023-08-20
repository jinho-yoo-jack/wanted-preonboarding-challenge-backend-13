import { Module } from '@nestjs/common';
import { TheaterController } from './theater.controller';
import { TheaterService } from './theater.service';
import { Theater } from './entity/theater.entity';

@Module({
  controllers: [TheaterController],
  providers: [TheaterService, Theater],
})
export class TheaterModule {}
