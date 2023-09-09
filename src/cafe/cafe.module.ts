import { Module } from '@nestjs/common';
import { CafeController } from './cafe.controller';
import { CafeService } from './cafe.service';
import { Cafe } from './entity/cafe.entity';
import { Cashier } from './entity/cashier.entity';
import { Barista } from './entity/barista.entity';
import { pgModule } from './infra/pg/pg.module';

const Entities = [Cafe, Barista, Cashier];
@Module({
  imports: [pgModule],
  controllers: [CafeController],
  providers: [CafeService, ...Entities],
})
export class CafeModule {}
