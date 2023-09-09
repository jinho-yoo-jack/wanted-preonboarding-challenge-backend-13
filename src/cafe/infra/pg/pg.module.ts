import { Module } from '@nestjs/common';
import { PgService } from './pg.service';

@Module({
  imports: [],
  providers: [PgService],
  exports: [PgService],
})
export class pgModule {}
