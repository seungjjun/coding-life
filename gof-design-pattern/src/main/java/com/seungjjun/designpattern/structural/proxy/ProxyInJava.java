package com.seungjjun.designpattern.structural.proxy;

import java.lang.reflect.Proxy;

public class ProxyInJava {

	public static void main(String[] args) {
		ProxyInJava proxyInJava = new ProxyInJava();
		proxyInJava.dynamicProxy();
	}

	private void dynamicProxy() {
		GameService gameServiceProxy = getGameServiceProxy(new DefaultGameService());
		gameServiceProxy.startGame();
	}

	private GameService getGameServiceProxy(GameService target) {
		return (GameService) Proxy.newProxyInstance(this.getClass().getClassLoader(),
			new Class[]{GameService.class}, ((proxy, method, args) -> {
				System.out.println("dynamic proxy");
				method.invoke(target, args);
				return null;
		}));
	}
}
