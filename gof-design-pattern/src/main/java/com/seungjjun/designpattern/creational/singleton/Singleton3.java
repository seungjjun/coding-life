package com.seungjjun.designpattern.creational.singleton;

public class Singleton3 {

	private static final Singleton3 INSTANCE = new Singleton3();

	private Singleton3() {
	}

	// 이른 초기화 사용 (thread safe)
	public static Singleton3 getInstance() {
		return INSTANCE;
	}

}
