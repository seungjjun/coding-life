package com.seungjjun.designpattern.structural.proxy;

public class DefaultGameService implements GameService {
	@Override
	public void startGame() {
		System.out.println("게임 시작");
	}
}
