## 싱글톤 (Singleton) 패턴

인스턴스를 오직 한개만 제공하는 클래스  

- 시스템 런타임, 환경 세팅에 대한 정보 등, 인스턴스가 여러개일 때 문제가 생길 수 있는 경우가 있다. 인스턴스를 오직 한개만 만들어 제공하는 클래스가 필요하다.

### 목적
- 인스턴스를 오직 한개만 만든다.
- 만들어진 한개의 인스턴스에 글로벌하게 접근할 수 있는 방법을 제공

### 싱글톤 패턴 복습
- 자바에서 enum을 사용하지 않고 싱글톤 패턴을 구현하는 방법은?
- private 생성자와 static 메소드를 사용하는 방법의 단점은?
- enum을 사용해 싱글톤 패턴을 구현하는 방법의 장점과 단점은?
- static inner 클래스를 사용해 싱글톤 패턴을 구현
