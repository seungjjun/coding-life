package com.seungjjun.designpattern.structural.proxy;

public class GameServiceProxy implements GameService  {

	private final GameService gameService;

	public GameServiceProxy(GameService gameService) {
		this.gameService = gameService;
	}

	@Override
	public void startGame() {
		long before = System.currentTimeMillis();
		gameService.startGame();
		System.out.println(System.currentTimeMillis() - before);
	}
}
