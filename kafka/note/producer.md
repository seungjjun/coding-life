# Producer

프로듀서는 카프카에 적재하기 위한 데이터를 선언하고 브로커의 특정 토픽의 파티션에 전송한다.  
프로듀서는 데이터를 전송할 때 리더 파티션을 가지고 있는 브로커와 직접 통신한다.  
프로듀서는 카프카 브로커로 데이터를 전송할 때 내부적으로 파티셔너, 배치 생성 단계를 거친다.  

## 프로듀서 내부 구조
레코드 전송 흐름  
ProducerRecord(send()) -> partitioner -> accumulator -> cluster

- ProducerRecord: 프로듀서에서 생성하는 레코드
- partitioner: 레코드를 어떤 파티션으로 전송할지 지정하는 파티셔너, 기본값으로 DefaultPartitioner로 설정이 된다.
  - 레코드의 메시지 키에 따라 파티셔너가 어떻게 동작할지 결정이 된다.
- accumulator: 배치로 묶어 전송할 데이터를 모으는 버퍼.

## 프로듀서의 기본 partitioner
프로듀서API를 사용하는 경우 "UniformStickyPartitioner", "RoundRobinPartitioner" 2개 파티셔너를 제공한다.  
default는 UniformStickyPartitioner 을 사용한다.  

### 메시지 키가 있을 경우
- "UniformStickyPartitioner", "RoundRobinPartitioner" 둘 다 메시지 키가 있으면 메시지 키의 해시값과 파티션을 매칭하여 레코드를 전송한다.
- 동일한 메시지 키가 존재하는 레코드는 동일한 파티션 번호에 전달된다.
- 만약 파티션 개수가 변경이 되면 메시지 키와 파티션 번호 매칭은 깨지게 된다.

### 메시지 키가 없을 경우
- RoundRobinPartitioner
  - ProducerRecord 가 들어오는 대로 파티션을 순회하며 전송한다.
  - accumulator 에서 묶이는 정도가 적기 때문에 전송 성능이 낮다.
- UniformStickyPartitioner
  - RoundRobinPartitioner의 단점을 개선한 방식
  - accumulator 에서 레코드들이 배치로 묶일 때까지 기다렸다가 전송.
  - 배치로 묶일 뿐 결국 파티션을 순회하면서 보내기 때문에 모든 파티션에 분배되어 전송.

## 프로듀서의 커스텀 partitioner
커스텀 파티셔너를 생성하기 위해 partitioner 인터페이스를 제공한다.  
partitioner 인터페이스를 상속받은 사용자 정의 클래스에서 메시지 키 또는 메시지값에 따른 파티션 지정 로직을 적용할 수 있다.  
- 추가로 메시지 키와 메시지 값을 조합하여 특정 파티션 번호를 지정하여 레코드를 전송할 수 있다. (ex. "홍길동" 이라는 메시지 키를 가진 레코드는 0번 파티션에 저장같은 커스텀 로직 작성이 가능)
