package com.seungjjun.designpattern.creational.factorymethod;

public class BlackshipFactory implements ShipFactory {
	@Override
	public Ship createShip() {
		return new Blackship();
	}
}
