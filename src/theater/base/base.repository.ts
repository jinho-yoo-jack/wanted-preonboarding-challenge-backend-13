import { BaseEntity } from './base.entity';

export class BaseRepository<Entity extends BaseEntity<any>> {
  constructor(private repository: Entity[]) {}

  getRepository() {
    return this.repository;
  }
}
