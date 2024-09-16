package com.seungjjun.designpattern.creational.singleton;

import java.io.Serializable;

public class Singleton6 implements Serializable {

	private Singleton6() { }

	// inner class 사용
	private static class SettingsHolder {
		private static final Singleton6 INSTANCE = new Singleton6();
	}

	// thread safe
	public static Singleton6 getInstance() {
		return SettingsHolder.INSTANCE;
	}

	// 역직렬화 할때 사용되는 메서드
	protected Object readResolve() {
		return getInstance();
	}
}
