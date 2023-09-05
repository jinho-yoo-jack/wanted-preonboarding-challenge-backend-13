import { TheaterRepository } from './repository/theater.repository';
import { Injectable } from '@nestjs/common';
import { User } from './entity/user.entity';
import { MessageType } from './types/seller-message.type';

// todo 완료 2. 컨트롤러에서 받은 dto를 가지고 관람객 정보를 사용한다.
// 하나의 티켓에 모든 인원수가 적혀있을 수 있다. 아직은 고려하지 말자.
// theater 엔티티가 모든 엔티티에 의존하고 있는데, 각 엔티티의 서비스를 만들어서 의존성 분리 필요.
@Injectable()
export class TheaterService {
  constructor(private readonly theaterRepository: TheaterRepository) {}

  //todo theater의 역할이 없고, ticketSeller의 역할이 비대함. 나눌 필요 있음.
  // audience가 초대권 or 티켓을 갖고 있고 그게 지금 입장해야하는 연극이라면 입장시키기
  enter(user: User): MessageType {
    // const results = this.theater.enter(user);
    // theater가 여러개라면, user 객체에 방문한 theater id를 넣고, 해당 id를 갖는 theater를 get
    const [theater] = this.theaterRepository.getRepository();
    // ticketSeller는 여러명일 수 있고, 이미 고객을 응대하고 있는 상황일 수 있음. isWorking 필드를 둬서 현재 tickSeller의 상태에 따라 일을 시켜야함.

    return theater.enter(user);
  }
}
