package com.seungjjun.designpattern.creational.factorymethod;

public class WhiteshipFactory implements ShipFactory {
	@Override
	public Ship createShip() {
		return new Whiteship();
	}
}
