import { Module } from '@nestjs/common';
import { CafeController } from './cafe.controller';
import { CafeService } from './cafe.service';
import { Cafe } from './entity/cafe.entity';

@Module({
  controllers: [CafeController],
  providers: [CafeService, Cafe],
})
export class CafeModule {}
