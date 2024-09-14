package com.seungjjun.designpattern.singleton;

// 권장되는 방식 중 하나
public class Singleton5 {

	private Singleton5() { }

	// inner class 사용
	private static class SettingsHolder {
		private static final Singleton5 INSTANCE = new Singleton5();
	}

	// thread safe
	public static Singleton5 getInstance() {
		return SettingsHolder.INSTANCE;
	}

}
