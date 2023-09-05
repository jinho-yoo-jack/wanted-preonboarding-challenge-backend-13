import dayjs from 'dayjs';
import { ulid } from 'ulid';

export interface CreateEntityProps<T> {
  id?: string;
  props?: T;
  createdAt?: dayjs.Dayjs;
  updatedAt?: dayjs.Dayjs;
  deletedAt?: dayjs.Dayjs;
}

export abstract class BaseEntity<EntityProps> {
  private readonly id?: string;
  private readonly createdAt?: dayjs.Dayjs;
  private updatedAt?: dayjs.Dayjs;
  private deletedAt?: dayjs.Dayjs;
  protected readonly props?: EntityProps;

  constructor({
    id,
    props,
    createdAt,
    updatedAt,
    deletedAt,
  }: CreateEntityProps<EntityProps>) {
    this.id = id || ulid();
    this.props = props;
    this.createdAt = createdAt || dayjs();
    this.updatedAt = updatedAt || dayjs();
    this.deletedAt = deletedAt || dayjs();
  }

  getId() {
    return this.id;
  }

  getCreatedAt() {
    return this.createdAt;
  }

  getUpdatedAt() {
    return this.updatedAt;
  }

  getDeletedAt() {
    return this.deletedAt;
  }

  getProps() {
    const propsCopy = {
      id: this.id,
      createdAt: this.createdAt,
      updatedAt: this.updatedAt,
      deletedAt: this.deletedAt,
      ...this.props,
    };

    return Object.freeze(propsCopy);
  }
}
