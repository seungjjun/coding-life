# Partition
카프카의 파티션은 자료구조의 큐(FIFO)와 비슷한 구조라고 생각하면 된다.  
다만 큐는 데이터를 pop 하면 데이터를 삭제하지만 카프카에서는 데이터를 삭제하지 않는다.  

1개의 토픽에는 1개 이상의 파티션을 갖고 있다.

## 토픽 생성 시 파티션이 배치되는 방법
파티션이 5개인 토픽을 생성하면 파티션은 라운드 로빈 방식으로 여러 브로커에 배치된다. (리더 파티션 부터 생성)  
카프카 클라이언트는 여러 브로커에 배치된 리더 파티션과 통신하여 데이터를 주고 받기 때문에 분산 네트워크 통신을 하게 된다  
-> 데이터가 특정 서버와 통신이 집중되는 현상을 막고 데이터가 많아지더라도 자연스럽게 대응이 가능

특정 브로커에 파티션이 쏠려 배치되는 현상이 발생하면 카프카 클라이언트가 파티션이 몰려있는 브로커와 네트워크 통신이 많아져 부하가 발생할 수 있다.  
-> 이러한 현상을 막는 것이 카프카 클러스터를 운영할때 중요한 부분. (kafka reassign partitions 으로 파티션 재할당)

## 파티션 개수와 컨슈머 개수의 관계
1개의 파티션은 1개의 컨슈머와 1:1 관계로 맺어진다. 1개의 파티션은 최대 1개의 컨슈머만 가질 수 있다. (반대로 1개의 컨슈머가 2개의 파티션을 통해 데이터를 처리할 수 있다.)  
컨슈머의 처리량이 한전된 상황에서 레코드를 효율적으로 병렬 처리하기 위해 컨슈머의 개수를 늘릴 수 있다.  
컨슈머 개수를 늘림과 동시에 파티션의 개수도 늘리면 데이터 처리량이 증가하는 효과를 얻을 수 있다.  

- 만일 프로듀서가 초당 10개의 데이터를 보내고 컨슈머가 초당 1개의 데이터를 처리할 수 있는 경우 데이터를 처리할 때 지연이 발생하는데 이러한 경우를 '컨슈머 랙'이 발생한다고 한다.
- 파티션의 개수를 줄이는 것은 불가능하므로 파티션을 늘릴 때 신중해야 한다.