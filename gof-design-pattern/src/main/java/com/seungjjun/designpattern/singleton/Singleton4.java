package com.seungjjun.designpattern.singleton;

public class Singleton4 {

	private static volatile Singleton4 instance;

	private Singleton4() {
	}

	// double checked locking 으로 효율적인 동기화 블럭 만들기.
	// 여러 쓰레드에서 instance가 null인 경우에만 synchronized가 걸려 성능에 이점이 있음
	public static Singleton4 getInstance() {
		if (instance == null) {
			synchronized (Singleton4.class) {
				if (instance == null) {
					instance = new Singleton4();
				}
			}
		}
		return instance;
	}

}
