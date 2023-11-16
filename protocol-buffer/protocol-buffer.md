# Protocol Buffer

<br/>

## Protocol Buffer란?
Protocol Buffer는 Google에서 개발한 구조화된 데이터를 직렬화 및 역직렬화를 빠르고 효율적이게 해주는 포맷이다.

JSON이나 XML과 비교할 때 더 작은 크기, 더 빠른 속도를 가지는 효율적인 데이터 직렬화를 제공한다.

'.proto' 파일을 통해 아래 예제 코드와 같이 데이터 구조를 정의한다.

```
syntax = "proto3";

message SearchRequest {
  string query = 1;
  int32 page_number = 2;
  int32 results_per_page = 3;
}
```

데이터 구조를 정의한 proto 파일은 Protocol Buffer 컴파일러를 통해 자신의 언어에 맞는 소스 코드로 변환이 가능하다. 이렇게 생성된 코드는 자신의 언어에서 데이터를 직렬화하거나 역직렬화하는 데 사용된다.

