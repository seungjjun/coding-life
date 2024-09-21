package com.seungjjun.designpattern.structural.proxy;

public class Client {

	public static void main(String[] args) {
		GameService gameService = new GameServiceProxy(new DefaultGameService());
		gameService.startGame();
	}
}
