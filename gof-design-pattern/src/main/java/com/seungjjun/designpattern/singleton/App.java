package com.seungjjun.designpattern.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class App {

	public static void main(String[] args)
		throws IOException, NoSuchMethodException, InvocationTargetException, InstantiationException,
		IllegalAccessException, ClassNotFoundException {
		Singleton singleton = Singleton.getInstance();

		System.out.println(singleton == Singleton.getInstance());  // -> true

		// 싱글톤 패턴 구현 꺠트리는 방법 1 (리플렉션 사용)
		Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
		constructor.setAccessible(true);
		Singleton singleton1 = constructor.newInstance();

		System.out.println(singleton == singleton1);  // -> false

		// 싱글톤 패턴 구현 꺠트리는 방법 2 (직렬화 & 역직렬화 사용)
		Singleton singleton2 = null;
		try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("singleton.obj"))) {
			out.writeObject(singleton);
		}

		try (ObjectInput in = new ObjectInputStream(new FileInputStream("singleton.obj"))) {
			singleton2 = (Singleton) in.readObject();
		}

		System.out.println(singleton == singleton2);
	}
}
