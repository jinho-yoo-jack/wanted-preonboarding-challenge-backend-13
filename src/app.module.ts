import { Module } from '@nestjs/common';
import { TheaterModule } from './theater/theater.module';
import { CafeModule } from './cafe/cafe.module';

@Module({
  imports: [TheaterModule, CafeModule],
  controllers: [],
  providers: [],
})
export class AppModule {}
