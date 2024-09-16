package com.seungjjun.designpattern.creational.singleton;

public class Singleton2 {

	private static Singleton2 instance;

	private Singleton2() {
	}

	// 가장 간단한 thread safe 한 방법  (synchronized 사용)
	public static synchronized Singleton2 getInstance() {
		if (instance == null) {
			instance = new Singleton2();
		}

		return instance;
	}
}
