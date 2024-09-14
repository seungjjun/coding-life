package com.seungjjun.designpattern.singleton;

public class Singleton {

	private static Singleton instance;

	private Singleton() {
	}

	// thread safe 하지 않음
	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}

		return instance;
	}
}
