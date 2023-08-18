# wanted-preonboarding-challenge-backend-13
원티드 프리온보딩 백엔드 챌린지 사전과제

## 과제1
- 비즈니스 요구사항: 소극장에 입장하는 관객의 티켓을 확인하고, 만약 티켓이 없다면 구매 후, 입장을 시키고 티켓이 있다면 티켓 확인 후, 입장 시킨다.
- 문제: 위 "비즈니스 요구사항"에 맞게 개발된 Theater 패키지가 있다. 하지만, 실행은 잘 되지만 패키지에는 2가지 문제점을 가지고 있다.
    1. 코드를 읽는 사람이 코드(ex. 관람객의 상태나 행동)를 예측할 수 없다.
    2. 변경의 유연함을 토대로 확장성을 가지고 있지 않다.
- 과제
    1. Theater 패키지의 코드를 읽는 사람이 쉽게 이해할 수 있고 예측할 수 있도록 수정 해보자.
    2. 매일 변화하는 비즈니스 요구사항의 변경에 유연하고 기능 확장성을 가지는 코드로 수정 해보자.
    3. TheaterService의 enter() 비즈니스 로직이 정상 실행되는지 확인해보자.
       - 관람객의 정보는 RequestMessage로 받아서 처리하자.
       - 관람객은 초대권 티켓을 가지고 있을 수도 있고 없을 수도 있다.

### 과제1: 비즈니스 요구사항 해석
- 관객은 극장에 입장할 수 있다.
- 극장에 입장하기 위해서는 티켓이 있어야 한다.
- 관객은 티켓을 가지고 있을 수도 아닐수도 있다.
- 관객에게 티켓이 없다면 구매 후 입장 처리 한다.

---
        
## 과제2
- 비즈니스 요구사항: WantedCafe에서 아메리카노만 주문 및 결제가 가능한데, 다른 음료도 주문 및 결제가 가능하게 수정해주세요.
- 문제: 위 "비즈니스 요구사항"에 맞게 개발 완료 및 정상 실행은 되지만 확장성과 유지보수성이 낮다.
- 과제
    1. 현재 주문 가능한 음료는 오직 아메리카노뿐인데, 주문 가능한 음료의 수를 최대 3개까지 확장해보자.
    2. 각각의 객체들이 적절한 책임과 책임의 범위를 가지고 있는지 확인해보고, 너무 많은 책임과 넓은 범위의 책임을 가지고 있다면 적절하게 수정해보자.
    3. CafeService의 order() 비즈니스 로직이 정상 실행되는지 확인해보자.
       - 주문할 음료와 수량은 RequestBody로 받아서 처리하자.
      
## 과제 제출 방법
1. master 브랜치로 프로젝트를 clone 해주세요.
2. 로컬 레파지토리에 `feature/이름or닉네임`으로 피쳐 브랜치를 생성해주세요.
4. 이제부터 사전과제를 풀어봅니다.
5. 모든 사전과제를 풀었다면 이제 원격 레파지토리에 commit 및 push 후 PR을 올려 해주세요.
6. Example
   ```shell
    1. git checkout -b feature/migration2TcAsMasterSlaveStructure
    # 브랜치를 생성하고 해당 브랜치로 checkout.
    # feature의 브랜치명은 내부적으로 관리하는 issues번호나 프로젝트 관리도구에의 ID 값을 이용
    2. git add .
    # 모든 변경사항을 tracking 되는 상태로 변경할거에요.
    3. git commit -m “Commit Messsage for Modify Information”
    # git commit를 수행하고 작업내용을 팀 내부 규약대로 작성
    3-1. git push --set-upstream origin feature/migration2TcAsMasterSlaveStructure
    # 해당 내용을 remote repository로 push
    4. push하면 gitlab/github에 Pull Request나 Merge Request 생성하는 버튼이 활성화
    5. Merge Request 버튼을 클릭 후, 숙제에 관한 내용 작성 후 PR 요청을 보내면 끝
    6. Merge 승인이되면 WEB UI화면에서 merge 버튼이 활성화 됨.
   ```
   


