import { Module } from '@nestjs/common';
import { TheaterController } from './theater.controller';
import { TheaterService } from './theater.service';
import { TheaterRepository } from './repository/theater.repository';
import { InvitationRepository } from './repository/invitation.repository';
import { TicketOfficeRepository } from './repository/ticket-office.repository';
import { TicketSellerRepository } from './repository/ticket-seller.repository';
import { TicketRepository } from './repository/ticket.repository';

const Services = [TheaterService];

const Repositories = [
  TheaterRepository,
  InvitationRepository,
  TicketOfficeRepository,
  TicketSellerRepository,
  TicketRepository,
];
@Module({
  imports: [],
  controllers: [TheaterController],
  providers: [...Services, ...Repositories],
})
export class TheaterModule {}
