package com.seungjjun.designpattern.creational.singleton;

// 리플렉션에 안전하고 단순한 방법 -> enum 객체는 리플렉션 사용 불가
// enum은 기본적으로 Serializable 을 구현하고 있다.
public enum Singleton7 {

	INSTANCE;

}
