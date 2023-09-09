import { User } from './user.entity';
import { TicketSeller } from './ticket-seller.entity';
import { MessageType } from '../types/seller-message.type';
import { BaseEntity, CreateEntityProps } from '../base/base.entity';
import { Seat } from './seat.entity';

// 3. 완료 ticketSeller는 언제나 Theater에 종속적이다. 생성자 주입하자. 그리고 enter 인자의 ticketSeller를 없고 필드 값을 사용하자.
// 4. 완료 그리고 enter 메소드의 기능은 관람객이 티켓이 있는지 없는지에 따라 입장을 시켜주느냐 아니냐 이다.
// 5. 완료 따라서 관람객이 초대권을 갖고 있는지 확인하고 티켓을 판매하는 행위는 seller에게 책임이 있으므로 위임한다.
// 6. 완료 관람객이 티켓을 살 돈이 있는지도 검증해야 한다.
//todo 연극 이름과 시간을 갖는 movie entity 만들기
// 완료 좌석 개수는 theater가 갖는다.
// 완료 seats 엔터티 만들기: 고유 id와 가격을 갖는다. theater에서 setter 주입해주기. repository로 추후 대체
//todo ticket을 판매했을 때 seat의 ticketId에 값을 넣어주고 isReserved 상태값 변경 해야함.
//todo private constructor로 typeorm 매핑 가능한지 확인필요
//todo ticketSeller는 여러명일 수 있다. 단 지금은 고려하지 않는다.
interface TheaterProps {
  ticketSeller: TicketSeller;
  seats: Seat[];
}

export class Theater extends BaseEntity<TheaterProps> {
  constructor({ props }: CreateEntityProps<TheaterProps>) {
    super({ props });
  }

  // sellTo : ticketOffice에게 티켓을 팔라고 메세지를 보냄
  // 캡슐화란 : 정보를 은닉하는 것을 의미하는 것이 아니다. 내부의 구현은 인스턴스 변수나 자료형을 숨기고 그것들이 직접적으로 다루어 지는 것들을 private으로한다. 비즈니스 로직을 수행하는, 즉 다른 객체가 보낸 메시지를 받는 메소드는 public으로 한다. public 메소드로 객체가 갖는 책임을 명시한다. 해당 메시지를 보내기 위해 객체를 의존하고 있는 객체는 캡슐화 된 것을 참조하지 않는다. 그렇지 않으면 코드 변경에 경직적이게된다.
  enter(user: User): MessageType {
    return this.props.ticketSeller.enter(user);
  }
}
