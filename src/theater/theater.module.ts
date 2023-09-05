import { Module } from '@nestjs/common';
import { TheaterController } from './theater.controller';
import { TheaterService } from './theater.service';
import { Theater } from './entity/theater.entity';
import { TicketSeller } from './entity/ticket-seller.entity';
import { TicketOffice } from './entity/ticket-office.entity';

const entities = [Theater, TicketSeller, TicketOffice];
@Module({
  controllers: [TheaterController],
  providers: [TheaterService, ...entities],
})
export class TheaterModule {}
